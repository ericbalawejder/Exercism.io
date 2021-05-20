import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Anagram {

    private final String word;
    private final BigInteger uniqueProductOfPrimes;
    private final static Map<Character, Integer> PRIMES;

    static {
        PRIMES = Map.ofEntries( Map.entry('a', 2),
                                Map.entry('b', 3),
                                Map.entry('c', 5),
                                Map.entry('d', 7),
                                Map.entry('e', 11),
                                Map.entry('f', 13),
                                Map.entry('g', 17),
                                Map.entry('h', 19),
                                Map.entry('i', 23),
                                Map.entry('j', 29),
                                Map.entry('k', 31),
                                Map.entry('l', 37),
                                Map.entry('m', 41),
                                Map.entry('n', 43),
                                Map.entry('o', 47),
                                Map.entry('p', 53),
                                Map.entry('q', 59),
                                Map.entry('r', 61),
                                Map.entry('s', 67),
                                Map.entry('t', 71),
                                Map.entry('u', 73),
                                Map.entry('v', 79),
                                Map.entry('w', 83),
                                Map.entry('x', 89),
                                Map.entry('y', 97),
                                Map.entry('z', 101)
        );
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
        return getWord().length() == word.length() &&
                !isSameWord(getWord(), word) &&
                getUniqueProductOfPrimes().equals(computeProduct(word));
    }

    private BigInteger computeProduct(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .map(PRIMES::get)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private boolean isSameWord(String word1, String word2) {
        return word1.equalsIgnoreCase(word2);
    }

}
