// Translate RNA sequences into proteins.
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
//import com.google.common.base.Splitter;

class ProteinTranslator
{
    public static void main(String[] args)
    {
        //System.out.println(codonsToAminoAcids);
        //System.out.println(translate("UGGUGC"));
        String rna = "UGUUAAUAGUAUUUU";
        
        //System.out.println(Arrays.toString(codon.split("(?<=\\G.{3})")));
        
        //String[] codons = rna.split("(?<=\\G.{3})");
        // String[] codons = rnaSequence.split("(?<=\\G.{3})");
        /*
        for(String subString : Splitter.fixedLength(4).split(codon))
        {
            System.out.println(subString);
        }
        */
    }
    
    private static final Map<String, String> codonsToAminoAcids = new HashMap<>();
    
    static
    {
        codonsToAminoAcids.put("AUG", "Methionine");
        codonsToAminoAcids.put("UUU", "Phenylalanine");
        codonsToAminoAcids.put("UUC", "Phenylalanine");
        codonsToAminoAcids.put("UUA", "Leucine");
        codonsToAminoAcids.put("UUG", "Leucine");
        codonsToAminoAcids.put("UCU", "Serine");
        codonsToAminoAcids.put("UCC", "Serine");
        codonsToAminoAcids.put("UCA", "Serine");
        codonsToAminoAcids.put("UCG", "Serine");
        codonsToAminoAcids.put("UAU", "Tyrosine");
        codonsToAminoAcids.put("UAC", "Tyrosine");
        codonsToAminoAcids.put("UGU", "Cysteine");
        codonsToAminoAcids.put("UGC", "Cysteine");
        codonsToAminoAcids.put("UGG", "Tryptophan");
        codonsToAminoAcids.put("UAA", "STOP");
        codonsToAminoAcids.put("UAG", "STOP");
        codonsToAminoAcids.put("UGA", "STOP");
    }
    
    static List<String> translate(String rnaSequence)
    {
        
        List<String> list = new ArrayList<>();
        if (codonsToAminoAcids.containsKey(rnaSequence))
        {
            if (codonsToAminoAcids.get(rnaSequence).equals("STOP"))
            {
                // Do nothing.
            }
            else
            {
                list.add(codonsToAminoAcids.get(rnaSequence));
            }
        }
        return list;
    }
}