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
        for (int divisor = 1; divisor <= Math.sqrt(n); divisor++)
        {
            // Handle perfect square cases.
            if (n % divisor == 0 && n / divisor != divisor)
            {
                int factor = n / divisor;
                aliquotSum += divisor + factor;
            }
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
