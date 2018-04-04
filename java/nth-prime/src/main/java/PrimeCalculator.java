import java.util.TreeSet;

// Given a number n, determine what the nth prime is.
class PrimeCalculator
{
    int nth(int nth)
    {
        if (nth < 1)
        {
            throw new IllegalArgumentException();
        }
        TreeSet<Integer> set = new TreeSet<>();
        int number = 2;
        while (set.size() != nth)
        {
            if (isPrime(number))
            {
                set.add(number);
            }
            number++;
        }
        return set.last();
    }

    boolean isPrime(int number)
    {
        for (int n = 2; n <= Math.sqrt(number); n++)
        {
            if (number % n == 0)
            {
                return false;
            }
        }
        return true;
    }
}
