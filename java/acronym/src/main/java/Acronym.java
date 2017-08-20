// Convert a phrase to its acronym.
class Acronym
{
    private final String phrase;
    
    Acronym(String phrase)
    {
        this.phrase = phrase;
    }

    String get()
    {
        // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        // Removes every character which is not on a word boundary on it's left.
        // Removes any character which is not a letter, including spaces.
        String result = phrase.replaceAll("\\B.|\\P{L}", "").toUpperCase();
        return result;
    }
}
