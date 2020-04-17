import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Scrabble {

    private final String word;
    private final int score;

    private static final Map<Integer, Integer> characterValues;

    static {
        Map<Integer, Integer> characters = new HashMap<>();
        "AEIOULNRST".chars().forEach(c -> characters.put(c, 1));
        "DG".chars().forEach(c -> characters.put(c, 2));
        "BCMP".chars().forEach(c -> characters.put(c, 3));
        "FHVWY".chars().forEach(c -> characters.put(c, 4));
        "K".chars().forEach(c -> characters.put(c, 5));
        "JX".chars().forEach(c -> characters.put(c, 8));
        "QZ".chars().forEach(c -> characters.put(c, 10));
        characterValues = Collections.unmodifiableMap(characters);
    }

    Scrabble(String word) {
        this.word = word;
        this.score = calculateScore(word);
    }

    int getScore() {
        return this.score;
    }

    private int calculateScore(String word) {
        return word.chars()
                .map(Character::toUpperCase)
                .map(letter -> characterValues.getOrDefault(letter, 0))
                .sum();
    }

}
