import java.util.Objects;
import java.util.stream.IntStream;

public class Hamming {
    private final String leftStrand;
    private final String rightStrand;
    private Integer hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else {
                throw new IllegalArgumentException(
                        "leftStrand and rightStrand must be of equal length.");
            }
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    // Lazy computation of hammingDistance.
    int getHammingDistance() {
        return this.hammingDistance =
                Objects.requireNonNullElseGet(hammingDistance,
                        () -> IntStream.range(0, leftStrand.length())
                        .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
                        .reduce(0, Integer::sum));
    }

}