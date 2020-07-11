import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class ProteinTranslator {
    private static final Map<String, String> CODONS_TO_PROTEIN;

    static {
        Map<String, String> rnaToProtein = new HashMap<>();
        rnaToProtein.put("AUG", "Methionine");
        rnaToProtein.put("UUU", "Phenylalanine");
        rnaToProtein.put("UUC", "Phenylalanine");
        rnaToProtein.put("UUA", "Leucine");
        rnaToProtein.put("UUG", "Leucine");
        rnaToProtein.put("UCU", "Serine");
        rnaToProtein.put("UCC", "Serine");
        rnaToProtein.put("UCA", "Serine");
        rnaToProtein.put("UCG", "Serine");
        rnaToProtein.put("UAU", "Tyrosine");
        rnaToProtein.put("UAC", "Tyrosine");
        rnaToProtein.put("UGU", "Cysteine");
        rnaToProtein.put("UGC", "Cysteine");
        rnaToProtein.put("UGG", "Tryptophan");
        rnaToProtein.put("UAA", "STOP");
        rnaToProtein.put("UAG", "STOP");
        rnaToProtein.put("UGA", "STOP");

        CODONS_TO_PROTEIN = Collections.unmodifiableMap(rnaToProtein);
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        String[] codons = rnaSequence.split("(?<=\\G.{3})");
        for (String codon : codons) {
            if (CODONS_TO_PROTEIN.containsKey(codon)) {
                if (CODONS_TO_PROTEIN.get(codon).equals("STOP")) {
                    break;
                } else {
                    proteins.add(CODONS_TO_PROTEIN.get(codon));
                }
            }
        }
        return proteins;
    }
}