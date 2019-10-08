import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.LongStream;

class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {
        final OptionalLong lowestPrime = LongStream.rangeClosed(2, number)
                .filter(i -> number % i == 0)
                .findFirst();

        final List<Long> primeFactors = new ArrayList<>();
        if (lowestPrime.isPresent()) {
            primeFactors.add(lowestPrime.getAsLong());
            primeFactors.addAll(calculatePrimeFactorsOf(number / lowestPrime.getAsLong()));
        }
        return Collections.unmodifiableList(primeFactors);
    }

    List<Long> calculatePrimeFactorsOf2(long number) {
        List<Long> primeFactors = new ArrayList<>();
        while (number % 2 == 0) {
            primeFactors.add((long) 2);
            number /= 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add((long) i);
                number /= i;
            }
        }
        if (number > 2) {
            primeFactors.add(number);
        }
        return Collections.unmodifiableList(primeFactors);
    }

    List<Long> calculatePrimeFactorsOf3(long number) {
        List<Long> primeFactors = new ArrayList<>();
        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                primeFactors.add((long) i);
                number /= i;
            }
        }
        if (number > 1) {
            primeFactors.add(number);
        }
        return Collections.unmodifiableList(primeFactors);
    }

}
