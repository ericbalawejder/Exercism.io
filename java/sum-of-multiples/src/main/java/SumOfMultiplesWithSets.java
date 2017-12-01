// A Java program to print all subsets of a set.
// Remove any elements that are divisible by other elements.
// Create a set of the set array.
// Create the power set of the set array.
// Use set difference: power set - set = set product multiples.
// sum set multiples - sum of set product multiples.
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class SumOfMultiplesWithSets
{
    public static void main(String[] args)
    {
        int[] array = {4, 6};
        SumOfMultiplesWithSets sumOfMultiples = new SumOfMultiplesWithSets(15, array);
        System.out.println(sumOfMultiples.getSum());
    }
    
    private final int number;
    private final int[] set;
    
    SumOfMultiplesWithSets(int number, int[] set)
    {
        this.number = number;
        this.set = set;
    }
    
    // Power set minus empty set.
    Set<Integer> powerSet(int array[])
    {
        Set<Integer> powerSet = new HashSet<>();
        int setSize = array.length;
        
        // 1 << setSize = 2^n
        for (int i = 0; i < (1 << setSize); i++)
        {
            int product = 1;
            for (int j = 0; j < setSize; j++)
            {
                if ((i & (1 << j)) > 0)
                {
                    product *= array[j];
                    powerSet.add(product);
                }
            }
            product = 1;
        }
        return powerSet;
    }
    
    int getSum()
    {
        boolean[] removed = new boolean[set.length];
        int trueCount = 0;
        for (int i = 0; i < set.length; i++)
        {
            for (int j = i + 1; j < set.length; j++)
            {
                if (set[i] > set[j] && set[i] % set[j] == 0)
                {
                    removed[i] = true;
                    trueCount++;
                }
                else if (set[i] < set[j] && set[j] % set[i] == 0)
                {
                    removed[j] = true;
                    trueCount++;
                }
            }
        }
        
        int[] setFinal = new int[set.length - trueCount];
        for (int i = 0; i < set.length; ++i)
        {
            if (!removed[i])
            {
                setFinal[i] = set[i];
            }
        }
        
        int sum = 0;
        for (int i = 0; i < setFinal.length; i++)
        {
            int n = number / setFinal[i];
            if (number % setFinal[i] == 0)
            {
                n -= 1;
            }
            sum += setFinal[i] * ((n * (n + 1)) / 2);
        }
        Set<Integer> setOfMultiples = new HashSet<>();
        Set<Integer> powerSet = new HashSet<>();
        setOfMultiples = Arrays.stream(setFinal).boxed().collect(Collectors.toSet());
        powerSet = powerSet(setFinal);
        Set<Integer> elementMultiples = new HashSet<>(powerSet);
        elementMultiples.removeAll(setOfMultiples);
        
        for (Integer element : elementMultiples)
        {
            int n = number / element;
            if (number % element == 0)
            {
                n -= 1;
            }
            sum -= element * ((n * (n + 1)) / 2);
        }
        return sum;
    }
}
