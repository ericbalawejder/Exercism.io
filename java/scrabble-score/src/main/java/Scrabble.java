import java.util.Map;
import java.util.HashMap;

class Scrabble {

    private final String word;

    private static final Map<Integer, Integer> characterMap = new HashMap<>();

    static {
        "AEIOULNRST".chars().forEach(c -> characterMap.put(c, 1));
        "DG".chars().forEach(c -> characterMap.put(c, 2));
        "BCMP".chars().forEach(c -> characterMap.put(c, 3));
        "FHVWY".chars().forEach(c -> characterMap.put(c, 4));
        "K".chars().forEach(c -> characterMap.put(c, 5));
        "JX".chars().forEach(c -> characterMap.put(c, 8));
        "QZ".chars().forEach(c -> characterMap.put(c, 10));
    }

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        return word.chars()
                .map(Character::toUpperCase)
                .map(letter -> characterMap.getOrDefault(letter, 0))
                .sum();
    }

}
