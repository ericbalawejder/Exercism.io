import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

    private final int limit;

    Sieve(int limit) {
        this.limit = limit;
    }

    List<Integer> getPrimes() {
        Set<Integer> notPrime = new HashSet<>();

        IntStream.rangeClosed(2, (int) Math.sqrt(limit))
                .flatMap(x -> IntStream.iterate(x * x, n -> n <= limit, n -> x + n))
                .forEach(notPrime::add);

        return IntStream.rangeClosed(2, limit)
                .filter(x -> !notPrime.contains(x))
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

}
