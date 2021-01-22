import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BaseConverter {

    private final int base;
    private final int[] representation;

    BaseConverter(int base, int[] representation) {
        basesMustBeAtLeastTwo(base);
        representationCanNotHaveNegativeNumbers(representation);
        digitsMustBeStrictlyLessThanBase(representation, base);
        this.base = base;
        this.representation = representation;
    }

    int[] convertToBase(int base) {
        basesMustBeAtLeastTwo(base);
        final int base10 = convertRadixToBaseTen(getRepresentation(), getBase());
        return convertBaseTenToRadix(base10, base);
    }

    int getBase() {
        return this.base;
    }

    int[] getRepresentation() {
        return Arrays.copyOf(this.representation, representation.length);
    }

    private int convertRadixToBaseTen(int[] representation, int base) {
        final int n = representation.length;
        return IntStream.iterate(n - 1, i -> i >= 0, i -> i - 1)
                .map(i -> (int) (representation[i] * Math.pow(base, n - i - 1)))
                .sum();
    }

    private int[] convertBaseTenToRadix(int number, int radix) {
        if (number == 0) {
            return new int[]{0};
        }

        return IntStream.iterate(number, i -> i > 0, i -> i / radix)
                .map(i -> i % radix)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(ArrayList::new), list -> {
                            Collections.reverse(list);
                            return list.stream();
                        }
                )).mapToInt(Integer::intValue)
                .toArray();
    }

    private void basesMustBeAtLeastTwo(int base) {
        if (base < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
    }

    private void representationCanNotHaveNegativeNumbers(int[] sequence) {
        Arrays.stream(sequence)
                .forEach(i -> {
                    if (i < 0) {
                        throw new IllegalArgumentException("Digits may not be negative.");
                    }
                });
    }

    private void digitsMustBeStrictlyLessThanBase(int[] sequence, int base) {
        Arrays.stream(sequence)
                .forEach(i -> {
                    if (i >= base) {
                        throw new IllegalArgumentException("All digits must be strictly less than the base.");
                    }
                });
    }
}
