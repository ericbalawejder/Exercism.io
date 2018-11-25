import java.util.List;
import java.util.ArrayList;

class PythagoreanTripletBuilder {
    int lower = 1;
    int upper;
    //int sum;
    // int sum = null;?
    Integer sum;

    PythagoreanTripletBuilder withFactorsGreaterThanOrEqualTo(int lower) {
        this.lower = lower;
        return this;
    }

    PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int upper) {
        this.upper = upper;
        return this;
    }

    PythagoreanTripletBuilder thatSumTo(int sum) {
        this.sum = sum;
        return this;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    List<PythagoreanTriplet> build() {
        List<PythagoreanTriplet> results = new ArrayList<>();

        for (int n = 1; n <= Math.sqrt(upper); n++) {
            for (int m = n + 1; m <= Math.sqrt(upper); m++) {
                if (gcd(m, n) == 1 && !(m % 2 != 0 && n % 2 != 0)) {
                    int a = ((int) (Math.pow(m, 2) - Math.pow(n, 2)));
                    int b = 2 * m * n;
                    int c = ((int) (Math.pow(m, 2) + Math.pow(n, 2)));
                
                    PythagoreanTriplet triplet = new PythagoreanTriplet(a, b, c);
                    if (triplet.isPythagorean() && a >= lower && b >= lower && c <= upper && (sum == null || triplet.calculateSum() == sum)) {
                        results.add(triplet);
                    }
                }
            }
        }
        return results;
    }
}
