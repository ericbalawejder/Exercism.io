import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

class PrimeFactorsCalculator {

    /*
    Does not add prime powers to the List, ex 27 = [3, 3, 3], 25 = [5, 5]
     */
    public static void main(String... args) {

        PrimeFactorsCalculator primeFactorsCalculator = new PrimeFactorsCalculator();
        System.out.println(primeFactorsCalculator.calculatePrimeFactorsOf(9L));
    }

    List<Long> calculatePrimeFactorsOf(Long number) {
        //List<Long> factors = new ArrayList<>();
        return LongStream.rangeClosed(2L, (int) Math.sqrt(number))
                .filter(this::isPrime)
                .filter(n -> number % n == 0)
                .boxed()
                .collect(Collectors.toList());

    }

    boolean isPrime(Long number) {
        return LongStream
                .rangeClosed(2L, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }

}
