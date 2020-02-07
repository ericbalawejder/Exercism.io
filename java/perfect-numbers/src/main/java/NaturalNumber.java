import java.util.stream.IntStream;

class NaturalNumber {

    private final int n;

    NaturalNumber(int naturalNumber) {
        if (naturalNumber <= 0) {
              throw new IllegalArgumentException(
                  "You must supply a natural number (positive integer)");
        }
        this.n = naturalNumber;
    }

    Classification getClassification() {
        return Classification.values()[Integer.compare(computeAliquotSum(), n) + 1];
    }

    private int computeAliquotSum() {
        return IntStream.rangeClosed(1, n / 2)
                .filter(i -> n % i == 0)
                .sum();
    }

}
