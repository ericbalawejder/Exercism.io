public class IsbnVerifier2
{
    public static void main(String[] args)
    {
        System.out.println(validateIsbn10("3-598-21508-8"));
    }
    
    public static boolean validateIsbn10(String stringToVerify)
    {
        isbn = stringToVerify.replaceAll("-", "");

        //must be a 10 digit ISBN
        if (isbn.length() != 10)
        {
            return false;
        }

        try
        {
            int sumOfProduct = 0;
            for (int i = 0; i < 9; i++)
            {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                sumOfProduct += ((10 - i) * digit);
            }

            if (isbn.substring(9, 10).equals("X"))
            {
                sumOfProduct += 10;
            }
            else
            {
                sumOfProduct += Integer.parseInt(isbn.substring(9, 10));
            }

            return sumOfProduct % 11 == 0;
        }
        catch (NumberFormatException nfe)
        {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }
}
