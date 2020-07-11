import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

        CODONS_TO_PROTEIN = Collections.unmodifiableMap(rnaToProtein);
    }

    List<String> translate(String rnaSequence) {
        return Arrays.stream(rnaSequence.split("(?<=\\G.{3})"))
                .map(CODONS_TO_PROTEIN::get)
                .takeWhile(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }
}