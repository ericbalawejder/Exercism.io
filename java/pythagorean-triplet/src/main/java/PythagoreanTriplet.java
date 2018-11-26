public class PythagoreanTriplet {

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
}
