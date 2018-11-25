import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String...args) {
        PythagoreanTriplet triple = new PythagoreanTriplet(3, 4, 5);
        System.out.println(triple.pythagorean(1, 100));
    }

    private int a;
    private int b;
    private int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    int calculateSum() {
        return a + b + c;
    }

    long calculateProduct() {
        return a * b * c;
    }

    boolean isPythagorean() {
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }

    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c;
    }

    //--------------------- For testing only ----------------------//

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    List<PythagoreanTriplet> pythagorean(int lower, int upper) {
        List<PythagoreanTriplet> results = new ArrayList<>();

        for (int n = 1; n <= Math.sqrt(upper); n++) {
            for (int m = n + 1; m <= Math.sqrt(upper); m++) {
                if (gcd(m, n) == 1 && !(m % 2 != 0 && n % 2 != 0)) {
                    int a = ((int) (Math.pow(m, 2) - Math.pow(n, 2)));
                    int b = 2 * m * n;
                    int c = ((int) (Math.pow(m, 2) + Math.pow(n, 2)));
                
                    PythagoreanTriplet triplet = new PythagoreanTriplet(a, b, c);
                    if (triplet.isPythagorean() && a >= lower && b >= lower && c <= upper) {
                        results.add(triplet);
                    }
                }
            }
        }
        return results;
    }
}
