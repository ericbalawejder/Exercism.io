class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        if (numerator != 0 && denominator == 0) {
            throw new ArithmeticException("denominator can not be zero");
        }
        final Pair<Integer, Integer> rationalValues = canonicalForm(numerator, denominator);
        this.numerator = rationalValues.getFirst();
        this.denominator = rationalValues.getSecond();
    }

    Rational add(Rational rational) {
        final Triplet<Integer, Integer, Integer> terms = createCommonDenominator(rational);
        return new Rational(terms.getFirst() + terms.getSecond(), terms.getThird());
    }

    Rational subtract(Rational rational) {
        final Triplet<Integer, Integer, Integer> terms = createCommonDenominator(rational);
        return new Rational(terms.getFirst() - terms.getSecond(), terms.getThird());
    }

    Rational multiply(Rational rational) {
        final int numerator = this.numerator * rational.getNumerator();
        final int denominator = this.denominator * rational.getDenominator();
        return new Rational(numerator, denominator);
    }

    Rational divide(Rational rational) {
        return this.multiply(rational.reciprocal());
    }

    Rational abs() {
        final int numerator = (int) Math.sqrt(Math.pow(this.numerator, 2));
        final int denominator = (int) Math.sqrt(Math.pow(this.denominator, 2));
        return new Rational(numerator, denominator);
    }

    Rational pow(int n) {
        final int numerator = (int) Math.pow(this.numerator, n);
        final int denominator = (int) Math.pow(this.denominator, n);
        return new Rational(numerator, denominator);
    }

    double exp(double base) {
        if (base < 0) throw new ArithmeticException("does not handle complex roots");
        final double power = Math.pow(base, Math.abs(this.numerator));
        final double root = Math.round(Math.pow(power, 1.0 / this.denominator));
        return this.numerator < 0 ? 1 / root : root;
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
                && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }

    private Triplet<Integer, Integer, Integer> createCommonDenominator(Rational rational) {
        final int commonDenominator = lcm(this.denominator, rational.getDenominator());
        final int multiplier1 = commonDenominator / this.denominator;
        final int multiplier2 = commonDenominator / rational.getDenominator();
        final int numeratorOperand1 = multiplier1 * this.numerator;
        final int numeratorOperand2 = multiplier2 * rational.getNumerator();

        return new Triplet<>(numeratorOperand1, numeratorOperand2, commonDenominator);
    }

    private Pair<Integer, Integer> canonicalForm(int a, int b) {
        int numerator = a;
        int denominator = b;
        final int gcd = Math.abs(gcd(numerator, denominator));
        if (!(gcd == 0 || gcd == 1)) {
            numerator /= gcd;
            denominator /= gcd;
        }
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        return new Pair<>(numerator, denominator);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a == 0 || b == 0) ? 0 : Math.abs(a * b) / gcd(a, b);
    }

    private Rational reciprocal() {
        return new Rational(this.denominator, this.numerator);
    }

}
