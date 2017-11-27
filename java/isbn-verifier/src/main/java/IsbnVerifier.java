// Check if a given ISBN-10 is valid.
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.Arrays;

class IsbnVerifier
{
    public static void main(String[] args)
    {
        System.out.println(isValid("3-598-21502-X"));
    }
    
    static boolean isValid(String stringToVerify)
    {
        String stringIsbn = stringToVerify.replaceAll( "\\-", "");
        
        if ( stringIsbn.length() != 10 )
        {
            return false;
        }
        
        //if (!stringIsbn.matches("^.+?\\d$"))
        if (!stringIsbn.matches("\\d+"))
        {
            if (!stringIsbn.matches(".*X"))
            {
                return false;
            }
            else
            {
                // X = 10    "3-598-21502-X"
                //stringToVerify = "3-598-21502-10"
            }
        }
        
        
        long isbn = Long.parseLong(stringIsbn);
        
        int[] isbnDigits = numberToDigitArray(isbn);
        
        // isbnConstants = {isbnDigits.length,....., 3, 2, 1}
        int[] isbnConstants = 
            IntStream.iterate(isbnDigits.length, n -> n - 1).limit(isbnDigits.length).toArray();
        
        int sumOfProduct = 0;
        for (int i = 0; i < isbnConstants.length; i++)
        {
            sumOfProduct += isbnDigits[i] * isbnConstants[i];
        }
        
        return sumOfProduct % 11 == 0;
    }
    
    static int[] numberToDigitArray(long number)
    {
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0)
        {
            stack.push((int)(number % 10));
            number = number / 10;
        }
        int[] isbnDigits = new int[stack.size()];
        for (int i = 0; i < isbnDigits.length; i++)
        {
            isbnDigits[i] = stack.pop();
        }
        return isbnDigits;
    }
}
