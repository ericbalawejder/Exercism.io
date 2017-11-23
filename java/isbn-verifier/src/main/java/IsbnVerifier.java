// Check if a given ISBN-10 is valid.
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

class IsbnVerifier
{
    public static void main(String[] args)
    {
        System.out.println(isValid("3-598-21508-8"));
        
        long number = 3598215088L;
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0)
        {
            stack.push((int)(number % 10));
            number = number / 10;
        }

        int[] isbnDigits = new int[10];
        for (int i = 0; i < 10; i++)
        {
            isbnDigits[i] = stack.pop();
        }
        
        for (int i = 0; i < 10; i++)
        {
            System.out.print(isbnDigits[i] + "  ");
        }
        System.out.println();
        
        int[] constants = IntStream.iterate(10, n -> n - 1).limit(10).toArray();
        
        for (int i = 0; i < constants.length; i++)
        {
            System.out.print(constants[i] + "  ");
        }
        System.out.println();
    }
    
    static boolean isValid(String stringToVerify)
    {
        if (stringToVerify == null)
        {
            return false;
        }
        
        String stringIsbn = stringToVerify.replaceAll( "\\-", "");
        
        if ( stringIsbn.length() != 10 )
        {
            return false;
        }
        long isbn = Long.parseLong(stringIsbn);
        //---------------
        LinkedList<Integer> stack = new LinkedList<>();
        while (isbn > 0)
        {
            stack.push((int)(isbn % 10));
            isbn = isbn / 10;
        }

        int[] isbnDigits = new int[10];
        for (int i = 0; i < 10; i++)
        {
            isbnDigits[i] = stack.pop();
        }
        //----------------
        //int[] constants = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] isbnConstants = IntStream.iterate(10, n -> n - 1).limit(10).toArray();
        int sumOfProduct = 0;
        for (int i = 0; i < 10; i++)
        {
            sumOfProduct += isbnDigits[i] * isbnConstants[i];
        }
        
        return sumOfProduct % 11 == 0;
    }
}
