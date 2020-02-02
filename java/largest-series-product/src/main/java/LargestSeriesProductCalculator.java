import java.util.stream.IntStream;

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
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length of the string to search.");
        } else if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else {
            return IntStream.range(0, inputNumber.length() - numberOfDigits + 1)
                    .mapToLong(i -> calculateProduct(i, numberOfDigits))
                    .max()
                    .getAsLong();
        }
    }

    private long calculateProduct(int index, int numberOfDigits) {
        return inputNumber.substring(index, index + numberOfDigits)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);
    }

}
