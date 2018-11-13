import java.util.List;
import java.util.ArrayList;

// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product a * b * c.
public class PythagoreanTriplet {

    public static void main(String...args) {
        System.out.println(pythagorean(1000));
        pythagoreanTriple(5, 20, 1000);
        
        PythagoreanTriplet triple = new PythagoreanTriplet(3, 4, 5);
        System.out.println(triple.calculateSum());
    }

    private long a, b, c;

    public PythagoreanTriplet(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int calculateSum() {
        return (int)(a + b + c);
    }

    public long calculateProduct() {
        return a * b * c;
    }
    // Method to find a pythag triple such that a + b + c = sum
    private static List<Integer> pythagorean(int sum)
    {
        int n = 1;
        int m = 1;
        List<Integer> results = new ArrayList<>();
        for (n = 1; n < sum / 2; n++)
        {
            for (m = 1; m < sum / 2; m++)
            {
                if (m * (m + n) == sum / 2 && m > n)
                {
                    //System.out.println("n = " + n + " and m = " + m);
                    results.add(m);
                    results.add(n);
                }
            }
        }
        return results;
    }

    private static void pythagoreanTriple(int n, int m, int sum)
    {
        int a = 2 * m * n;
        int b = ((int) (Math.pow(m, 2) - Math.pow(n, 2)));
        int c = ((int) (Math.pow(m, 2) + Math.pow(n, 2)));

        System.out.println(a + " + " + b + " + " + c + " = " + sum);
        System.out.println("Their product is " + a * b * c);
    }
}
