// Determine if a number is perfect, abundant, or deficient based on
// Nicomachus' (60 - 120 CE) classification scheme for natural numbers.
class NaturalNumber
{
    public static void main(String[] args)
    {
        //System.out.println(classify(24));
        NaturalNumber number = new NaturalNumber(24);
        System.out.println(number.getClassification());
    }
    
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
        for (int divisor = 1; divisor < n; divisor++)
        {
            if (n % divisor == 0)
            {
                aliquotSum += divisor;
            }
        }
        return aliquotSum;
    }
    
    Classification getClassification()
    {
        Classification classify = null;
        if (aliquotSum(naturalNumber) == naturalNumber)
        {
            classify = Classification.PERFECT;
        }
        if (aliquotSum(naturalNumber) < naturalNumber)
        {
            classify = Classification.DEFICIENT;
        }
        if (aliquotSum(naturalNumber) > naturalNumber)
        {
            classify = Classification.ABUNDANT;
        }
        return classify;
    }
}
