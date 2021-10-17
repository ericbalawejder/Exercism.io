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
        final double ac = this.real * complexNumber.getReal();
        final double bd = this.imaginary * complexNumber.getImag();
        final double ad = this.real * complexNumber.getImag();
        final double bc = this.imaginary * complexNumber.getReal();
        final double sumDivisorSqd = Math.pow(complexNumber.getReal(), 2) +
                Math.pow(complexNumber.getImag(), 2);
        final double real = (ac + bd) / sumDivisorSqd;
        final double imaginary = (bc - ad) / sumDivisorSqd;

        return new ComplexNumber(real, imaginary);
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, this.imaginary * -1);
    }

    public ComplexNumber exponentialOf() {
        final double real = Math.pow(Math.E, this.real);
        final double cosB = Math.cos(this.imaginary);
        final double sinB = Math.sin(this.imaginary);
        return new ComplexNumber(real * cosB, real * sinB);
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

}
