import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(this::isPrime)
                .limit(nth)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    boolean isPrime(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }

}
