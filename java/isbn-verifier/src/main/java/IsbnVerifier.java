class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String isbn = stringToVerify.replaceAll("-", "");

        if (isbn.length() != 10) {
            return false;
        }
        try {
            int sumOfProduct = 0;

            for (int i = 0; i < 9; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                sumOfProduct += ((10 - i) * digit);
            }
            if (isbn.startsWith("X", 9)) {
                sumOfProduct += 10;
            } else {
                sumOfProduct += Integer.parseInt(isbn.substring(9, 10));
            }
            return sumOfProduct % 11 == 0;

        } catch (NumberFormatException numberFormatException) {
            // Catch invalid ISBNs that have non-numeric characters in them from parseInt().
            return false;
        }
    }

}
