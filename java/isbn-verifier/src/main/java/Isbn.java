// Check if a given ISBN-10 is valid.
public class Isbn {

    boolean isValid(String stringToVerify) {
        String isbn = stringToVerify.replaceAll("-", "");

        if (isbn.length() != 10) {
            return false;
        }

        int sumOfProduct = 0;
        // If there exists a non digit.
        if (!isbn.matches("\\d+")) {
            // This non digit must be an "X" at the end of the string.
            if (!isbn.matches(".*X")) {
                return false;
            } else {
                for (int i = 0; i < 9; i++) {
                    int digit = Integer.parseInt(isbn.substring(i, i + 1));
                    sumOfProduct += ((10 - i) * digit);
                }
                sumOfProduct += 10;
            }
            return sumOfProduct % 11 == 0;
        } else {
            for (int i = 0; i < 10; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                sumOfProduct += ((10 - i) * digit);
            }
        }
        return sumOfProduct % 11 == 0;
    }

}
