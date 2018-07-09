// Determine if a sentence is a pangram.
import java.util.Set;
import java.util.HashSet;

public class PangramChecker {

  public static boolean isPangram(String input) {
    Set<Integer> set = new HashSet<>();

    input
        .toLowerCase()
        .chars()
        .filter(character -> (int)'a' <= character && character <= (int)'z')
        .forEach(
            character -> {
              if (!set.contains(character)) {
                set.add(character);
              }
            });
    return set.size() == 26;
  }
}
