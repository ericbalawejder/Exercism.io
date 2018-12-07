import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class WordCount {

    Map<String, Integer> phrase(String sentence) {
        Map<String, Integer> wordCountHash = new HashMap<>();

        String[] wordArray = Arrays.stream(sentence
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\'\\s]|\\B'|'\\B", " ")
                .trim()
                .split("\\s+"))
                .toArray(String[]::new);

        for (String word : wordArray) {
            Integer count = wordCountHash.get(word);
            wordCountHash.put(word, count == null ? 1 : count + 1);
        }
        return wordCountHash;
    }

}
