// Calculate the Hamming difference between two DNA strands.
public class Hamming
{
    private String leftStrand;
    private String rightStrand;
    
    Hamming(String leftStrand, String rightStrand)
    {
        if (leftStrand.length() != rightStrand.length())
        {
            throw new IllegalArgumentException();
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance()
    {
        int distance = 0;
        for (int i = 0; i < leftStrand.length(); i++)
        {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
            {
                distance++;
            }
        }
        return distance;
    }
}
