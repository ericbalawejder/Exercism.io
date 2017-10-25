// Convert a number to a string, the contents of which depend on the number's factors.
class RaindropConverter
{
    String convert(int number)
    {
        String rainDrop = "";
        
        if (number % 3 == 0)
        {
            rainDrop += "Pling";
        }
        if (number % 5 == 0)
        {
            rainDrop += "Plang";
        }
        if (number % 7 == 0)
        {
            rainDrop += "Plong";
        }
        if (rainDrop.equals(""))
        {
            rainDrop = String.valueOf(number);
        }
        return rainDrop;
    }
}
