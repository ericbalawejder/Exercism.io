// Given a number determine whether or not it is valid per the Luhn formula.
class LuhnValidator
{
    boolean isValid(String candidate)
    {
        candidate = candidate.replaceAll("\\s", "");
        
        if (!candidate.matches("\\d+") || candidate.length() < 2)
        {
            return false;
        }
        String number = new StringBuilder(candidate).reverse().toString();
        int sum = 0;
        for (int i = 0; i < number.length(); i++)
        {
            int digit = 0;
            if (i % 2 == 1)
            {
                digit = Integer.parseInt(number.substring(i, i + 1));
                int product = digit * 2;
                if (product > 9)
                {
                    product -= 9;
                    sum += product;
                }
                else
                {
                    sum += product;
                }
            }
            else
            {
                digit = Integer.parseInt(number.substring(i, i + 1));
                sum += digit;
            }
        }
        return sum % 10 == 0;
    }
}
