import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NucleotideCounter {

    public static void main(String... args) {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("ACCCCGT");
        System.out.println(nucleotideCounter.strand);
        System.out.println(nucleotideCounter.nucleotideCounts());

        NucleotideCounter nucleotideCounter2 = new NucleotideCounter("");
        System.out.println(nucleotideCounter2.strand);
        System.out.println(nucleotideCounter2.nucleotideCounts());

    }

    private final String strand;

    NucleotideCounter(String strand) {
        if (!strand.matches("[ACGT]*")) {
            throw new IllegalArgumentException();
        }
        this.strand = strand;
    }

    Map<Character, Integer> nucleotideCounts() {
        Character[] nucleotides = strand.chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new);

        Map<Character, Integer> counts = Stream.of(nucleotides)
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));

        return Collections.unmodifiableMap(counts);
    }

}
