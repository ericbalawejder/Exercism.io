import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCount {

    Map<String, Integer> phrase(String sentence) {

        String[] words = sentence.replaceAll("[^a-zA-Z0-9\\'\\s]|\\B'|'\\B", " ")
                .toLowerCase()
                .trim()
                .split("\\s+");

        return Stream.of(words)
                .collect(Collectors.collectingAndThen(
                            Collectors.toMap(key -> key, value -> 1, Integer::sum),
                                    Collections::unmodifiableMap));
    }

}
