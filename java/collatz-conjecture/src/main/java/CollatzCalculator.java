// Collatz Conjecture https://en.wikipedia.org/wiki/Collatz_conjecture
class CollatzCalculator
{
    int computeStepCount(int n)
    {
        if (n < 1)
        {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        int count = 0;
        while (n > 1)
        {
            n = (n % 2 == 0 ? (n / 2) : (3 * n + 1));
            count++;
        }
        return count;
    }
}
