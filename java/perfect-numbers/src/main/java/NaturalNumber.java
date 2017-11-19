// Determine if a number is perfect, abundant, or deficient based on
// Nicomachus' (60 - 120 CE) classification scheme for natural numbers.
class NaturalNumber
{
    private final int naturalNumber;

    NaturalNumber(int naturalNumber)
    {
        if (naturalNumber <= 0)
        {
              throw new IllegalArgumentException(
                  "You must supply a natural number (positive integer)");
        }
        this.naturalNumber = naturalNumber;
    }

    int aliquotSum(int n)
    {
        int aliquotSum = 0;
        int squareRoot = (int)Math.sqrt(n);
        for (int divisor = 1; divisor <= squareRoot; divisor++)
        {
            if (n % divisor == 0)
            {
                int factor = n / divisor;
                aliquotSum += divisor + factor;
            }
        }
        // Handle perfect squares.
        if (n == Math.pow(squareRoot, 2))
        {
            aliquotSum -= squareRoot;
        }
        return aliquotSum - n;
    }

    Classification getClassification()
    {
        Classification classify;
        if (aliquotSum(naturalNumber) == naturalNumber)
        {
            classify = Classification.PERFECT;
        }
        else if (aliquotSum(naturalNumber) > naturalNumber)
        {
            classify = Classification.ABUNDANT;
        }
        else
        {
            classify = Classification.DEFICIENT;
        }
        return classify;
    }
}
