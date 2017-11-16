// Given a word, compute the scrabble score for that word.
import java.util.Map;
import java.util.HashMap;

class Scrabble
{
    private static final Map<String, Integer> characterMap = new HashMap<>();

    static
    {
        characterMap.put("AEIOULNRST", 1);
        characterMap.put("DG", 2);
        characterMap.put("BCMP", 3);
        characterMap.put("FHVWY", 4);
        characterMap.put("K", 5);
        characterMap.put("JX", 8);
        characterMap.put("QZ", 10);
    }

    private String word;

    Scrabble(String word)
    {
        this.word = word;
    }

    int getScore()
    {
        int scrabbleScore = 0;
        for (int i = 0; i < word.length(); i++)
        {
            String letter = String.valueOf(word.charAt(i));
            // Make characterMap a set and iterate through each key(letter).
            for (Map.Entry<String, Integer> characterMapEntry : characterMap.entrySet())
            {
                if (characterMapEntry.getKey().contains(letter.toUpperCase()))
                {
                    scrabbleScore += characterMapEntry.getValue();
                }
            }
        }
        return scrabbleScore;
    }
}
