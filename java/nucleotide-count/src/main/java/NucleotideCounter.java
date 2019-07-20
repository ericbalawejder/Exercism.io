import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class NucleotideCounter {

    private final String strand;

    NucleotideCounter(String strand) {
        if (!strand.matches("[ACGT]*")) {
            throw new IllegalArgumentException();
        }
        this.strand = strand;
    }

    Map<Character, Integer> nucleotideCounts() {
        
        Map<Character, Integer> counts = IntStream.range(0, strand.length())
                .mapToObj(i -> strand.charAt(i))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, value -> 1, Integer::sum)));

        return Collections.unmodifiableMap(defaultMap(counts));
    }

    private Map<Character, Integer> defaultMap(Map<Character, Integer> counts) {
        counts.putIfAbsent('A', 0);
        counts.putIfAbsent('C', 0);
        counts.putIfAbsent('G', 0);
        counts.putIfAbsent('T', 0);
        return counts;
    }

}
