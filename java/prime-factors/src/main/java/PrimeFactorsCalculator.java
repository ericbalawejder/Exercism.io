import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> factors = new ArrayList<>();
        while (number % 2 == 0) {
            factors.add((long) 2);
            number /= 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add((long) i);
                number /= i;
            }
        }
        if (number > 2) {
            factors.add(number);
        }
        return Collections.unmodifiableList(factors);
    }

    List<Long> primeFactors(long number) {
        List<Long> factors = new ArrayList<>();
        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                factors.add((long) i);
                number /= i;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return Collections.unmodifiableList(factors);
    }

}
