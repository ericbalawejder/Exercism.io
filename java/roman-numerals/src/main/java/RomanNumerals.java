import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumerals {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    final private int value;

    RomanNumerals(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    static List<RomanNumerals> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumerals e) -> e.value).reversed())
                .collect(Collectors.toUnmodifiableList());
    }
}
