import java.util.Objects;

class ComplexNumber {

    private final double real;
    private final double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber times(ComplexNumber complexNumber) {
        final double ac = this.real * complexNumber.getReal();
        final double bd = this.imaginary * complexNumber.getImag();
        final double ad = this.real * complexNumber.getImag();
        final double bc = this.imaginary * complexNumber.getReal();
        final double real = ac - bd;
        final double imaginary = ad + bc;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        final double real = this.real + complexNumber.getReal();
        final double imaginary = this.imaginary + complexNumber.getImag();
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber minus(ComplexNumber complexNumber) {
        final double real = this.real - complexNumber.getReal();
        final double imaginary = this.imaginary - complexNumber.getImag();
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber div(ComplexNumber complexNumber) {
        return this.times(complexNumber.reciprocal());
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, this.imaginary * -1);
    }

    public ComplexNumber exponentialOf() {
        final double expA = Math.exp(this.real);
        final ComplexNumber polar = new ComplexNumber(Math.cos(this.imaginary), Math.sin(this.imaginary));
        return new ComplexNumber(expA, 0).times(polar);
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.real, real) == 0 && Double.compare(that.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public String toString() {
        final String sign = imaginary >= 0 ? "+" : "-";
        return real + " " + sign + " " + Math.abs(imaginary) + "i";
    }

    private ComplexNumber reciprocal() {
        final double sumDivisorSqd = Math.pow(this.getReal(), 2) + Math.pow(this.getImag(), 2);
        return new ComplexNumber(this.real / sumDivisorSqd, -this.imaginary / sumDivisorSqd);
    }

}
