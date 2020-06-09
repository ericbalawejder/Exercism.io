import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsbnVerifier {

    private static final String CHECK_DIGIT = "X";
    private static final int CHECK_DIGIT_VALUE = 10;
    private static final String PREFIX_978 = "978";
    private static final String PREFIX_979 = "979";

    public static void main(String[] args) {
        IsbnVerifier isbnVerifier = new IsbnVerifier();

        for (long i = 9780000000000L; i <= 9799999999999L; i++) {
            if (isbnVerifier.isValidIsbn13(String.valueOf(i))) {
                String isbn = isbnVerifier.convertIsbn13ToIsbn10(String.valueOf(i));
                if (isbn.endsWith("X")) {
                    System.out.println(i + " -> " + isbn);
                }
            }
        }
    }

    boolean isValid(String stringToVerify) {
        final String isbn = stringToVerify.replace("-", "");

        if (isbn.matches(".*[^0-9X].*")
                || isbn.length() != 10
                || isbn.substring(0, 10 - 1).contains(CHECK_DIGIT)) {
            return false;
        }
        final List<Integer> numbers = isbn.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(s -> CHECK_DIGIT.equals(s) ? CHECK_DIGIT_VALUE : Integer.parseInt(s))
                .collect(Collectors.toUnmodifiableList());

        return IntStream.range(0, isbn.length())
                .map(i -> (isbn.length() - i) * numbers.get(i))
                .reduce(0, Integer::sum) % 11 == 0;
    }

    boolean isValidIsbn13(String stringToVerify) {
        final String isbn13 = stringToVerify.replace("-", "");

        if (isbn13.matches(".*[^0-9].*")
                || isbn13.length() != 13
                || !isbn13.startsWith(PREFIX_978) && !isbn13.startsWith(PREFIX_979)) {
            return false;
        }
        final List<Integer> numbers = isbn13.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toUnmodifiableList());

        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 0) ? numbers.get(i) * 1 : numbers.get(i) * 3)
                .reduce(0, Integer::sum) % 10 == 0;
    }

    String convertIsbn10ToIsbn13(String stringToConvert) {
        if (!isValid(stringToConvert)) {
            throw new IllegalArgumentException("Not a valid isbn-10 number.");
        }
        final String isbn10 = stringToConvert.replace("-", "");
        final String isbn13 = PREFIX_978 + isbn10.substring(0,9);

        final List<Integer> numbers = isbn13.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toUnmodifiableList());

        final int sum = IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 0) ? numbers.get(i) * 1 : numbers.get(i) * 3)
                .reduce(0, Integer::sum);

        final int checkDigit = sum % 10 == 0 ? 0 : 10 - sum % 10;

        return isbn13 + checkDigit;
    }

    String convertIsbn13ToIsbn10(String stringToConvert) {
        if (!isValidIsbn13(stringToConvert)) {
            throw new IllegalArgumentException("Not a valid ISBN-13 number.");
        }
        final String isbn = stringToConvert.replace("-", "");

        final String isbn10 = isbn.substring(3, isbn.length() - 1);

        final List<Integer> numbers = isbn10.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toUnmodifiableList());

        final int checkDigit = IntStream.range(0, isbn10.length())
                .map(i -> (10 - i) * numbers.get(i))
                .reduce(0, Integer::sum) % 11;

        return checkDigit == 10 ? isbn10 + CHECK_DIGIT : isbn10 + checkDigit;
    }

}
