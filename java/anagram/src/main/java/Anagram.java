import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Anagram {

    private final String word;
    private final BigInteger uniqueProductOfPrimes;
    private final static Map<Character, Integer> PRIMES;
    
    static {
        Map<Character, Integer> charactersToPrimeNumber = new HashMap<>();
        charactersToPrimeNumber.put('a', 2);
        charactersToPrimeNumber.put('b', 3);
        charactersToPrimeNumber.put('c', 5);
        charactersToPrimeNumber.put('d', 7);
        charactersToPrimeNumber.put('e', 11);
        charactersToPrimeNumber.put('f', 13);
        charactersToPrimeNumber.put('g', 17);
        charactersToPrimeNumber.put('h', 19);
        charactersToPrimeNumber.put('i', 23);
        charactersToPrimeNumber.put('j', 29);
        charactersToPrimeNumber.put('k', 31);
        charactersToPrimeNumber.put('l', 37);
        charactersToPrimeNumber.put('m', 41);
        charactersToPrimeNumber.put('n', 43);
        charactersToPrimeNumber.put('o', 47);
        charactersToPrimeNumber.put('p', 53);
        charactersToPrimeNumber.put('q', 59);
        charactersToPrimeNumber.put('r', 61);
        charactersToPrimeNumber.put('s', 67);
        charactersToPrimeNumber.put('t', 71);
        charactersToPrimeNumber.put('u', 73);
        charactersToPrimeNumber.put('v', 79);
        charactersToPrimeNumber.put('w', 83);
        charactersToPrimeNumber.put('x', 89);
        charactersToPrimeNumber.put('y', 97);
        charactersToPrimeNumber.put('z', 101);
        PRIMES = Collections.unmodifiableMap(charactersToPrimeNumber);
    }

    Anagram(String word) {
        this.uniqueProductOfPrimes = computeProduct(word);
        this.word = word;
    }

    List<String> match(List<String> possibleMatches) {
        return possibleMatches.stream()
                .filter(this::isAnagram)
                .collect(Collectors.toUnmodifiableList());
    }

    BigInteger getUniqueProductOfPrimes() {
        return this.uniqueProductOfPrimes;
    }

    String getWord() {
        return this.word;
    }

    private boolean isAnagram(String word) {
        if (getWord().length() != word.length() || isSameWord(getWord(), word)) {
            return false;
        }
        return getUniqueProductOfPrimes().equals(computeProduct(word));
    }

    private BigInteger computeProduct(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .map(PRIMES::get)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, (p1, p2) -> p1.multiply(p2));
    }

    private boolean isSameWord(String word1, String word2) {
        return word1.toLowerCase().equals(word2.toLowerCase());
    }

}
