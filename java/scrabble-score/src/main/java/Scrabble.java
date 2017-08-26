// Given a word, compute the scrabble score for that word.
import java.util.HashMap;

class Scrabble
{
    private String word;
    
    Scrabble(String word)
    {
        this.word = word;
    }

    int getScore()
    {
        HashMap<String, Integer> characterValueHash = new HashMap<>();
        String[] wordArray = word.toUpperCase().split("");
        characterValueHash.put("", 0);
        characterValueHash.put("A", 1);
        characterValueHash.put("E", 1);
        characterValueHash.put("I", 1);
        characterValueHash.put("O", 1);
        characterValueHash.put("U", 1);
        characterValueHash.put("L", 1);
        characterValueHash.put("N", 1);
        characterValueHash.put("R", 1);
        characterValueHash.put("S", 1);
        characterValueHash.put("T", 1);
        characterValueHash.put("D", 2);
        characterValueHash.put("G", 2);
        characterValueHash.put("B", 3);
        characterValueHash.put("C", 3);
        characterValueHash.put("M", 3);
        characterValueHash.put("P", 3);
        characterValueHash.put("F", 4);
        characterValueHash.put("H", 4);
        characterValueHash.put("V", 4);
        characterValueHash.put("W", 4);
        characterValueHash.put("Y", 4);
        characterValueHash.put("K", 5);
        characterValueHash.put("J", 8);
        characterValueHash.put("X", 8);
        characterValueHash.put("Q", 10);
        characterValueHash.put("Z", 10);
                
        int scrabbleScore = 0;
        for (String character : wordArray)
        {
            if (characterValueHash.containsKey(character))
            {
                int characterValue = characterValueHash.get(character);
                scrabbleScore += characterValue;
            }
        }
        return scrabbleScore;
    }
}
