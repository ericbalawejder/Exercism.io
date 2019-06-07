import java.util.Set;
import java.util.HashSet;

public class PangramChecker {

    public static boolean isPangram(String input) {
        Set<Integer> set = new HashSet<>();

        input.toLowerCase().chars()
                .filter(Character::isAlphabetic)
                .forEach(character -> {
                    if (!set.contains(character)) {
                        set.add(character);
                    }
                });
        return set.size() == 26;
    }

}
