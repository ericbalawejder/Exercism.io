class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        } else {
            this.inputNumber = inputNumber;
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        long largestProduct = 0;

        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length " + "of the string to search.");
        } else if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else {

            int numberOfSubstrings = inputNumber.length() - numberOfDigits + 1;

            for (int i = 0; i < numberOfSubstrings; i++) {

                String substring = inputNumber.substring(i, i + numberOfDigits);
                long product = 1;

                for (int j = 0; j < numberOfDigits; j++) {
                    product *= Long.parseLong(substring.substring(j, j + 1));
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }
        return largestProduct;
    }

}
