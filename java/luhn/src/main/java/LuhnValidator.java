import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        String number = reverse(candidate).replaceAll("\\s", "");
        
        if (!number.matches("\\d+") || number.length() < 2) {
            return false;
        }
        String[] characters = number.split("");
        return IntStream.range(0, characters.length)
                .map(i -> (i % 2 == 1) ? Integer.parseInt(characters[i]) * 2
                                        : Integer.parseInt(characters[i]))
                .map(x -> (x > 9) ? x - 9 : x)
                .sum() % 10 == 0;
    }

    private String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

}