import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

// Sieve of Eratosthenes.
class Sieve
{
    private final int maxPrime;

    Sieve(int maxPrime)
    {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes()
    {
        List<Integer> primes = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= maxPrime; i++)
        {
            if (!set.contains(i))
            {
                primes.add(i);
            }
            int multiple = i;
            while (multiple <= maxPrime)
            {
                multiple += i;
                set.add(multiple);
            }
        }
        return primes;
    }
}
