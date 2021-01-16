import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(this::isPrime)
                .limit(nth)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isPrime(int number) {
        if (number <= 1) throw new IllegalArgumentException("Number must be > 1");
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        return IntStream.iterate(3, i -> i <= (int) Math.sqrt(number), i -> i + 2)
                .noneMatch(n -> number % n == 0);
    }

}
