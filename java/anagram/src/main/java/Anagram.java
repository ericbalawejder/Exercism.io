import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Using the fundamental theorem of arithmetic, determine if two words are anagrams.
// Limited by long memory.
class Anagram {

    private final String word;
    private final long primeFactorization;
    private final static Map<Character, Long> PRIMES;
    
    static {
        Map<Character, Long> charactersToPrimeNumber = new HashMap<>();
        charactersToPrimeNumber.put('a', 2L);
        charactersToPrimeNumber.put('b', 3L);
        charactersToPrimeNumber.put('c', 5L);
        charactersToPrimeNumber.put('d', 7L);
        charactersToPrimeNumber.put('e', 11L);
        charactersToPrimeNumber.put('f', 13L);
        charactersToPrimeNumber.put('g', 17L);
        charactersToPrimeNumber.put('h', 19L);
        charactersToPrimeNumber.put('i', 23L);
        charactersToPrimeNumber.put('j', 29L);
        charactersToPrimeNumber.put('k', 31L);
        charactersToPrimeNumber.put('l', 37L);
        charactersToPrimeNumber.put('m', 41L);
        charactersToPrimeNumber.put('n', 43L);
        charactersToPrimeNumber.put('o', 47L);
        charactersToPrimeNumber.put('p', 53L);
        charactersToPrimeNumber.put('q', 59L);
        charactersToPrimeNumber.put('r', 61L);
        charactersToPrimeNumber.put('s', 67L);
        charactersToPrimeNumber.put('t', 71L);
        charactersToPrimeNumber.put('u', 73L);
        charactersToPrimeNumber.put('v', 79L);
        charactersToPrimeNumber.put('w', 83L);
        charactersToPrimeNumber.put('x', 89L);
        charactersToPrimeNumber.put('y', 97L);
        charactersToPrimeNumber.put('z', 101L);
        PRIMES = Collections.unmodifiableMap(charactersToPrimeNumber);
    }

    Anagram(String word) {
        this.primeFactorization = primeFactorization(word);
        this.word = word;
    }

    List<String> match(List<String> possibleMatches) {
        return possibleMatches.stream()
                .filter(this::isAnagram)
                .collect(Collectors.toUnmodifiableList());
    }

    long getPrimeFactorization() {
        return this.primeFactorization;
    }

    String getWord() {
        return this.word;
    }

    private boolean isAnagram(String word) {
        if (getWord().length() != word.length() || isSameWord(getWord(), word)) {
            return false;
        }
        return getPrimeFactorization() == primeFactorization(word);
    }

    private long primeFactorization(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .map(PRIMES::get)
                .reduce(1L, (p1, p2) -> p1 * p2);
    }

    private boolean isSameWord(String word1, String word2) {
        return word1.toLowerCase().equals(word2.toLowerCase());
    }

}
