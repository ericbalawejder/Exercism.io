import java.util.stream.IntStream;

class SumOfMultiples {

    private final int sum;

    SumOfMultiples(int number, int[] set) {
        this.sum = computeSum(number, set);
    }

    int getSum() {
        return this.sum;
    }

    private int computeSum(int number, int[] set) {
        return IntStream.range(0, number)
                .filter(i -> {
                    for (int n: set) {
                        if ((n > 0) && (i % n == 0)) {
                            return true;
                        }
                    }
                    return false;
                })
                .sum();
    }

}
