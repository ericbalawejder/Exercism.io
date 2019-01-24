import java.util.stream.IntStream;

public class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException();
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        return IntStream
                .range(0, leftStrand.length())
                .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
                .sum();
    }

}
