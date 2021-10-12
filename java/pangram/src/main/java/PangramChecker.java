import java.util.stream.Collectors;

public class PangramChecker {

    private static final int ALPHABET_LENGTH = 26;

    boolean isPangram(String sentence) {
        return sentence.toLowerCase()
                .chars()
                .filter(Character::isAlphabetic)
                .boxed()
                .collect(Collectors.toUnmodifiableSet())
                .size() == ALPHABET_LENGTH;
    }

}
