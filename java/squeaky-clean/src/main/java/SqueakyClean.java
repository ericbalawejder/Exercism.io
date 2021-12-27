import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SqueakyClean {

    static String clean(String identifier) {
        return toCamelCase(identifier.split(""))
                .stream()
                .filter(Predicate.not(String::isEmpty))
                .map(c -> c.replace(" ", "_"))
                .map(c -> Character.isISOControl(c.charAt(0)) ? "CTRL" : c)
                .map(c -> (!Character.isAlphabetic(c.charAt(0)) && !c.equals("_")) ? "" : c)
                .map(c -> c.replaceAll("[α-ω]+", ""))
                .collect(Collectors.joining());
    }

    private static List<String> toCamelCase(String[] word) {
        final String[] characters = Arrays.copyOf(word, word.length);
        final int[] indexes = IntStream.range(0, characters.length)
                .filter(i -> characters[i].equals("-"))
                .toArray();

        for (int i : indexes) {
            characters[i + 1] = characters[i + 1].toUpperCase();
        }
        return Arrays.stream(characters)
                .filter(c -> !c.equals("-"))
                .collect(Collectors.toUnmodifiableList());
    }

}
