import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class AffineCipher {

    private static final int ALPHABET = 26;

    String encode(String text, int keyA, int keyB) {
        modularMultiplicativeInverse(keyA, ALPHABET);

        final String filteredText = text.toLowerCase()
                .replaceAll("[^a-zA-Z0-9]", "");

        final List<String> groups = group(filteredText, 5);

        return groups.stream()
                .map(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .map(c -> encrypt(c, keyA, keyB))
                        .collect(Collector.of(
                                StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::toString)))
                .collect(Collectors.joining(" "));
    }

    String decode(String encoding, int keyA, int keyB) {
        return encoding.replaceAll("\\s+", "")
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> decrypt(c, keyA, keyB))
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }

    private Character encrypt(Character character, int keyA, int keyB) {
        final int index = character - 'a';
        final int encryptedNumericValue = (keyA * index + keyB) % ALPHABET;
        return Character.isAlphabetic(character) ?
                (char) ('a' + encryptedNumericValue) : character;
    }

    private Character decrypt(Character character, int keyA, int keyB) {
        final int index = character - 'a';
        final int inverse = modularMultiplicativeInverse(keyA, ALPHABET);
        return Character.isAlphabetic(character) ?
                (char) (Math.floorMod(inverse * (index - keyB), ALPHABET) + 'a') : character;
    }

    private int modularMultiplicativeInverse(int n, int modulus) {
        if (gcd(n, modulus) != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }
        return IntStream.range(1, modulus)
                .filter(i -> Math.floorMod(n * i, modulus) == 1)
                .findFirst()
                .getAsInt();
    }

    private List<String> group(String text, int size) {
        return IntStream.iterate(0, n -> n < text.length(), n -> n + size)
                .mapToObj(n -> text.substring(n, Math.min(text.length(), n + size)))
                .collect(Collectors.toUnmodifiableList());
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}