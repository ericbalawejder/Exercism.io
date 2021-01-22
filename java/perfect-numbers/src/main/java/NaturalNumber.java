import java.util.stream.IntStream;

class NaturalNumber {

    private final int n;
    private final Classification classification;

    NaturalNumber(int naturalNumber) {
        if (naturalNumber <= 0) {
              throw new IllegalArgumentException(
                  "You must supply a natural number (positive integer)");
        }
        this.n = naturalNumber;
        this.classification =
                Classification.values()[Integer.compare(computeAliquotSum(), n) + 1];
    }

    Classification getClassification() {
        return classification;
    }

    private int computeAliquotSum() {
        return IntStream.rangeClosed(1, n / 2)
                .filter(i -> n % i == 0)
                .sum();
    }

}
