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
                .mapToObj(strand::charAt)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, value -> 1, Integer::sum)));

        return defaultMap(counts);
    }

    private Map<Character, Integer> defaultMap(Map<Character, Integer> counts) {
        counts.putIfAbsent('A', 0);
        counts.putIfAbsent('C', 0);
        counts.putIfAbsent('G', 0);
        counts.putIfAbsent('T', 0);
        return Collections.unmodifiableMap(counts);
    }

}
