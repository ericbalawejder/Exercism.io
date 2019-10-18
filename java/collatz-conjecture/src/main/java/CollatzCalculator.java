import java.util.stream.IntStream;

class CollatzCalculator {

    long computeStepCount(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        return IntStream.iterate(number, n -> n % 2 == 0 ? n / 2 : 3 * n + 1)
                .takeWhile(n -> n != 1)
                .count();
    }

}