import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NucleotideCounter {

    public static void main(String... args) {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("ACCCCGT");
        System.out.println(nucleotideCounter.strand);
        System.out.println(nucleotideCounter.nucleotideCounts());

        NucleotideCounter nucleotideCounter2 = new NucleotideCounter("ACCCCGT");
        System.out.println(nucleotideCounter2.strand);
        System.out.println(nucleotideCounter2.nucleotideCounts());

    }

    private final String strand;
    private final Map<Character, Integer> counts;

    NucleotideCounter(String strand) {
        if (!strand.matches("[ACGT]*")) {
            throw new IllegalArgumentException();
        }
        this.strand = strand;
        this.counts = createCountsMap();
    }

    Map<Character, Integer> nucleotideCounts() {
        char[] nucleotides = strand.toCharArray();
        for (Character nucleotide : nucleotides) {
            if (counts.containsKey(nucleotide)) {
                Integer count = counts.get(nucleotide);
                counts.put(nucleotide, count + 1);
            }
        }
        return counts;
    }

    private Map<Character, Integer> createCountsMap() {
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('A', 0);
        counts.put('C', 0);
        counts.put('G', 0);
        counts.put('T', 0);
        return counts;
    }

}
