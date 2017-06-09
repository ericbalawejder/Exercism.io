public class RnaTranscription 
{
    public static String transcribe(String dnaStrand) 
    {
        char[] dnaCharacterArray = dnaStrand.toCharArray();
        String rnaStrand = "";
        for (int i = 0; i < dnaCharacterArray.length; i++)
        {
            // append each transcribed char to String rnaStrand
            rnaStrand += rnaTranscription(dnaCharacterArray[i]);
        }
        return rnaStrand;
    }

    // private method for character mappings
    private static String rnaTranscription(Character dnaStrand) 
    {
        switch(dnaStrand) 
        {
            case 'C': return "G";
            case 'G': return "C";
            case 'T': return "A";
            case 'A': return "U";
            default: return "?";
        }
    }
}