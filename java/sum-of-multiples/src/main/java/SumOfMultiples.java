// Given a number, find the sum of all the multiples of particular 
// numbers up to but not including that number.
import java.util.Set;
import java.util.HashSet;

class SumOfMultiples
{
    private final int number;
    private final int[] set;
    
    SumOfMultiples(int number, int[] set)
    {
        this.number = number;
        this.set = set;
    }

    int getSum()
    {
        Set<Integer> setOfMultiples = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < set.length; i++)
        {
            for (int j = 1; j < number; j++)
            {
                if (j % set[i] == 0)
                {
                    setOfMultiples.add(j);
                }
            }
        }
        for (Integer element : setOfMultiples)
        {
            sum += element;
        }
        return sum;
    }
}
