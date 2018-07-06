// Determine if a sentence is a pangram.
import java.util.HashSet;
import java.util.Set;

import java.util.stream.Stream;
import java.util.stream.IntStream;

public class PangramChecker {

  public static void main(String... args) {
    String testTrue = "the_quick_brown_fox_jumps_over_the_lazy_dog";
    String testFalse = "a quick movement of the enemy will jeopardize five gunboats";
    String testWithNumbersTrue = "the 1 quick brown foX Jumps over the 2 lazy doGs";

    System.out.println(isPangram(testWithNumbersTrue));
    System.out.println(isPangram(testWithNumbersTrue));
    System.out.println(isPangram(testWithNumbersTrue));

    Stream<Character> characterStream = testFalse.chars()
      .mapToObj(c -> (char) c);
    characterStream.forEach(System.out::print);
    
    System.out.println();
  }

  public static boolean isPangram(String input) {
    Set<Integer> set = new HashSet<>();

    input
        .toLowerCase()
        .chars()
        .filter(character -> Character.isAlphabetic(character))
        .forEach(
            e -> {
              if (!set.contains(e)) {
                set.add(e);
              }
            });
    return set.size() == 26;
  }
}
