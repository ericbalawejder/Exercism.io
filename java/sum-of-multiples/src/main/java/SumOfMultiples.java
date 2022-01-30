import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {

    private final int sum;

    SumOfMultiples(int limit, int[] multiples) {
        this.sum = computeSum(limit, multiples);
    }

    int getSum() {
        return this.sum;
    }

    private int computeSum(int limit, int[] multiples) {
        return IntStream.range(0, limit)
                .filter(i -> isAFactor(multiples, i))
                .sum();
    }

    private boolean isAFactor(int[] multiples, int i) {
        return Arrays.stream(multiples)
                .anyMatch(n -> (n > 0) && (i % n == 0));
    }

}
