import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsbnVerifier {

    private static final int ISBN_FORMAT = 10;
    private static final String CHECK_DIGIT = "X";
    private static final int CHECK_DIGIT_VALUE = 10;
    private static final String FILTER = ".*[^0-9X].*";
    
    public boolean isValid(String stringToVerify) {
        final String isbn = stringToVerify.replace("-", "");

        if (isbn.matches(FILTER) ||
                isbn.length() != ISBN_FORMAT ||
                isbn.substring(0, ISBN_FORMAT - 1).contains(CHECK_DIGIT)) {

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

    public static void main(String[] args) {
        IsbnVerifier isbn = new IsbnVerifier();
        String isbn10 = "3-598-21508-8";
        System.out.println(isbn.isValid(isbn10));
        System.out.println(isbn.convertIsbn10ToIsbn13(isbn10));

    }

    public String convertIsbn10ToIsbn13(String isbn10) {
        final String isbn = isbn10.replace("-", "");

        if (isbn.matches(FILTER) ||
                isbn.length() != ISBN_FORMAT ||
                isbn.substring(0, ISBN_FORMAT - 1).contains(CHECK_DIGIT)) {

            throw new IllegalArgumentException("Not a valid isbn-10 value");
        }
        final String isbn13 = "978" + isbn.substring(0,9);

        final List<Integer> numbers = isbn13.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toUnmodifiableList());

        final int sum = IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 0) ? numbers.get(i) * 1 : numbers.get(i) * 3)
                .reduce(0, Integer::sum);

        final int checkDigit = 10 - sum % 10;
        return isbn13 + checkDigit;
    }

}
