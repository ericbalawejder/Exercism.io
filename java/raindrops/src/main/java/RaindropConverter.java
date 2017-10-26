// Convert a number to a string, the contents of which depend on the number's factors.
class RaindropConverter
{
    String convert(int number)
    {
        StringBuilder rainDrop = new StringBuilder();
        
        if (number % 3 == 0)
        {
            rainDrop.append("Pling");
        }
        if (number % 5 == 0)
        {
            rainDrop.append("Plang");
        }
        if (number % 7 == 0)
        {
            rainDrop.append("Plong");
        }
        return rainDrop.toString().length() == 0 ? Integer.toString(number) : rainDrop.toString();
    }
}
