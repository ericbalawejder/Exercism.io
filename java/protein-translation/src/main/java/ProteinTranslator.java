// Translate RNA sequences into proteins.
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class ProteinTranslator
{
    private static final Map<String, String> codonsToProtein = new HashMap<>();

    static
    {
        codonsToProtein.put("AUG", "Methionine");
        codonsToProtein.put("UUU", "Phenylalanine");
        codonsToProtein.put("UUC", "Phenylalanine");
        codonsToProtein.put("UUA", "Leucine");
        codonsToProtein.put("UUG", "Leucine");
        codonsToProtein.put("UCU", "Serine");
        codonsToProtein.put("UCC", "Serine");
        codonsToProtein.put("UCA", "Serine");
        codonsToProtein.put("UCG", "Serine");
        codonsToProtein.put("UAU", "Tyrosine");
        codonsToProtein.put("UAC", "Tyrosine");
        codonsToProtein.put("UGU", "Cysteine");
        codonsToProtein.put("UGC", "Cysteine");
        codonsToProtein.put("UGG", "Tryptophan");
        codonsToProtein.put("UAA", "STOP");
        codonsToProtein.put("UAG", "STOP");
        codonsToProtein.put("UGA", "STOP");
    }

    List<String> translate(String rnaSequence)
    {
        List<String> protein = new ArrayList<>();
        String[] codons = rnaSequence.split("(?<=\\G.{3})");
        for (String codon : codons)
        {
            if (codonsToProtein.containsKey(codon))
            {
                if (codonsToProtein.get(codon).equals("STOP"))
                {
                    break;
                }
                else
                {
                    protein.add(codonsToProtein.get(codon));
                }
            }
        }
        return protein;
    }
}
