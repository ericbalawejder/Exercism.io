import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {

    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> scrabbleScores = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            for (String character : entry.getValue()) {
                scrabbleScores.put(character.toLowerCase(), entry.getKey());
            }
        }
        return Collections.unmodifiableMap(scrabbleScores);
    }

}
