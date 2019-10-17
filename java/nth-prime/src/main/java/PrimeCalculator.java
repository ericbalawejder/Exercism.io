import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(this::isPrime)
                .limit(nth)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    boolean isPrime(int number) {
        return IntStream
                .rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }

}
