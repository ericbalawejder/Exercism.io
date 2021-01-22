import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class IsogramChecker {

    boolean isIsogram(String input) {
        final String phrase = input.trim()
                .toLowerCase()
                .replaceAll("[^a-z]", "");

        return phrase.chars()
                .boxed()
                .collect(Collectors.toUnmodifiableSet())
                .size() == phrase.length();
    }

    boolean isIsogramImperative(String input) {
        char[] phrase = input.trim()
                .toLowerCase()
                .replaceAll("[^a-z]", "")
                .toCharArray();

        Set<Character> characters = new HashSet<>();
        for (char letter : phrase) {
            if (characters.contains(letter)) {
                return false;
            } else {
                characters.add(letter);
            }
        }
        return true;
    }

}
