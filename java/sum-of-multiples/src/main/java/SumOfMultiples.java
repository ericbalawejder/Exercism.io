// Given a number, find the sum of all the multiples of particular numbers up to
// but not including that number.
class SumOfMultiples
{
    public static void main(String[] args)
    {
        int[] multiples = {3, 5};
        SumOfMultiples sumOfMultiples = new SumOfMultiples(10, multiples);
        System.out.println(sumOfMultiples.getSum());
    }
    
    private int number;
    private int[] set;
    
    SumOfMultiples(int number, int[] set)
    {
        this.number = number;
        this.set = set;
    }

    // Remove multiples of set[], i.e. [3, 5], remove multiples of 15
    // 2, 3, 4 = 2^3 / 2 = 4, (2*3),(2*4),(3*4),(2*3*4)
    int getSum()
    {
        int sum = 0;
        for (int i = 0; i < set.length; i++)
        {
            int n = number / set[i];
            if (number % set[i] == 0)
            {
                n -= 1;
            }
            sum += set[i] * ((n * (n + 1)) / 2);
        }
        return sum;
    }

    int getSum2()
    {
        int sum = 0;
        for (int i = 0; i < set.length; i++)
        {
            for (int j = 1; j < number; j++)
            {
                if (j % set[i] == 0)
                {
                    sum += j;
                }
            }
            
        }
        return sum;
    }
}
