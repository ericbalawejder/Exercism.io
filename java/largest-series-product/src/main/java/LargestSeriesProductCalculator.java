class LargestSeriesProductCalculator
{
    public static void main(String[] args)
    {
        LargestSeriesProductCalculator series = new LargestSeriesProductCalculator("9987x99");
        System.out.println(series.calculateLargestProductForSeriesLength(3));
    }
    
    private final String inputNumber;
    
    LargestSeriesProductCalculator(String inputNumber)
    {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) throws IllegalArgumentException
    {
        long largestProduct = 0;
        if (numberOfDigits > inputNumber.length())
        {
            throw new IllegalArgumentException(
                "Series length must be less than or equal to the length of the string to search.");
        }
        else if (numberOfDigits < 0)
        {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        else
        {
            try
            {
                int numberOfSubstrings = inputNumber.length() - numberOfDigits + 1;
                for (int i = 0; i < numberOfSubstrings; i++)
                {
                    String substring = inputNumber.substring(i, i + numberOfDigits);
                    long product = 1;
                    for (int j = 0; j < numberOfDigits; j++)
                    {
                        product *= Long.parseLong(substring.substring(j, j + 1));
                    }
                    if (product > largestProduct)
                    {
                        largestProduct = product;
                    }
                }
            }
            catch (NumberFormatException numberFormatException)
            {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
        return largestProduct;
    }
}
