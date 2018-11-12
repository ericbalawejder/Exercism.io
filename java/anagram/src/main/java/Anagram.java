import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


// Using the fundamental theorem of arithmetic, determine if two words are anagrams.
// Limited by int product.
public class Anagram
{
    public static void main(String[] args)
    {
        Anagram anagram = new Anagram("racecar");
        System.out.println(anagram.match(Arrays.asList("Racecar", "racecar", "inlets", "RACECAR")));
    }

    private final String word;
    private final static Map<Character, Integer> characterMapping = new HashMap<Character, Integer>();
    
    // Map characters to prime numbers.
    static {
    characterMapping.put('a', 2);
    characterMapping.put('b', 3);
    characterMapping.put('c', 5);
    characterMapping.put('d', 7);
    characterMapping.put('e', 11);
    characterMapping.put('f', 13);
    characterMapping.put('g', 17);
    characterMapping.put('h', 19);
    characterMapping.put('i', 23);
    characterMapping.put('j', 29);
    characterMapping.put('k', 31);
    characterMapping.put('l', 37);
    characterMapping.put('m', 41);
    characterMapping.put('n', 43);
    characterMapping.put('o', 47);
    characterMapping.put('p', 53);
    characterMapping.put('q', 59);
    characterMapping.put('r', 61);
    characterMapping.put('s', 67);
    characterMapping.put('t', 71);
    characterMapping.put('u', 73);
    characterMapping.put('v', 79);
    characterMapping.put('w', 83);
    characterMapping.put('x', 89);
    characterMapping.put('y', 97);
    characterMapping.put('z', 101);
    }

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> possibleMatchesList) {
        List<String> matchingList = new ArrayList<>();
        for (String possibleMatch : possibleMatchesList) {
            if (isAnagram(possibleMatch)) {
                matchingList.add(possibleMatch);
            }
        }
        return matchingList;
    }

    public boolean isAnagram(String wordToCheck)
    {
        int product1 = 1;
        int product2 = 1;

        if (word.length() != wordToCheck.length()) {
            return false;
        } else {
            char[] characterArray1 = word.toLowerCase().toCharArray();
            char[] characterArray2 = wordToCheck.toLowerCase().toCharArray();

            for (int i = 0; i < word.length(); i++) {
                int value1 = characterMapping.get(characterArray1[i]);
                product1 *= value1;
                int value2 = characterMapping.get(characterArray2[i]);
                product2 *= value2;
            }
        }
        return product1 == product2; 
    }
}
