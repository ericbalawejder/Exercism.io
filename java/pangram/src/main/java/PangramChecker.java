// Determine if a sentence is a pangram.
import java.util.Set;
import java.util.HashSet;

public class PangramChecker {

  public static void main(String... args) {
    String testString = "Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich.";
    
    System.out.println(isPangram(testString));
    System.out.println(isPangram3(testString));
  }

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
  
  public static boolean isPangram3(String input) {
    return input
        .toLowerCase()
        .chars()
        //.filter(Character::isAlphabetic)
        .filter(character -> (int)'a' <= character && character <= (int)'z')
        .distinct()
        .count() == 26;
      }
}
