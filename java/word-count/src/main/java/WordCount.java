import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCount {

    Map<String, Integer> phrase(String sentence) {

        String[] words = sentence.replaceAll("[^a-zA-Z0-9\\'\\s]|\\B'|'\\B", " ")
                .toLowerCase().trim().split("\\s+");

        Map<String, Integer> wordCountMap = Stream.of(words)
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));
        return wordCountMap;
    }

}
