import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class ProteinTranslator {
    private static final Map<String, String> CODONS_TO_PROTEIN;

    static {
        CODONS_TO_PROTEIN = Map.ofEntries(
                Map.entry("AUG", "Methionine"),
                Map.entry("UUU", "Phenylalanine"),
                Map.entry("UUC", "Phenylalanine"),
                Map.entry("UUA", "Leucine"),
                Map.entry("UUG", "Leucine"),
                Map.entry("UCU", "Serine"),
                Map.entry("UCC", "Serine"),
                Map.entry("UCA", "Serine"),
                Map.entry("UCG", "Serine"),
                Map.entry("UAU", "Tyrosine"),
                Map.entry("UAC", "Tyrosine"),
                Map.entry("UGU", "Cysteine"),
                Map.entry("UGC", "Cysteine"),
                Map.entry("UGG", "Tryptophan")
        );
    }

    List<String> translate(String rnaSequence) {
        return Arrays.stream(rnaSequence.split("(?<=\\G.{3})"))
                .map(CODONS_TO_PROTEIN::get)
                .takeWhile(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }

}
