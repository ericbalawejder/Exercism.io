// Determine if a sentence is a pangram.
import java.util.Set;
import java.util.HashSet;
import java.lang.Character;

public class PangramChecker {

    public boolean isPangram(String input) {
        String downcased = input.toLowerCase();
        Set<Character> set = new HashSet<>();
        char[] characterArray = downcased.toCharArray();
        for (char character : characterArray) {
            // Ascii code [a-z]
            if ((int)'a' <= character && character <= (int)'z') {
                set.add(character);
            }
        }
        return set.size() == 26;
    }
}
