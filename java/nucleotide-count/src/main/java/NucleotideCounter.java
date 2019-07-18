import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

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

        Character[] nucleotides = strand.chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new);

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
