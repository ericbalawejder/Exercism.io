import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    public static void main(String... args) {
        PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();
        // System.out.println(pigLatinTranslator.pigLatin("my"));
        // System.out.println(pigLatinTranslator.pigLatin("rhythm"));
        System.out.println(pigLatinTranslator.translate("deez nuts ha got em"));

    }

    String translate(String phrase) {
        String[] words = phrase.replaceAll("[^\\w]", " ").split("\\s+");
        return Arrays.stream(words)
                .map(word -> pigLatin(word))
                .collect(Collectors.joining(" "));
    }

    private boolean isAVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private boolean isAVowelExcludingU(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O');
    }

    private boolean beginsWithAVowel(String word) {
        char firstCharacter = word.charAt(0);
        return isAVowel(firstCharacter);
    }

    private boolean isAVowelSound(String word) {
        return word.matches("^xr.*") || word.matches("^yt.*");
    }

    private boolean beginsWithAVowelSound(String word) {
        return isAVowelSound(word);
    }

    private boolean containsQU(String word) {
        return word.matches(".*qu.*");
    }

    private boolean secondLetterInTwoLetterWordContainsY(String word) {
        return word.length() == 2 && (word.charAt(1) == 'y' || word.charAt(1) == 'Y');
    }

    private String pigLatin(String word) {
        if (beginsWithAVowel(word) || beginsWithAVowelSound(word)) {
            return Stream.of(word, "ay").collect(Collectors.joining());
        }
        String prefix = "";
        String suffix = "";
        for (int i = 0; i < word.length(); i++) {

            if (isAVowel(word.charAt(i)) && !containsQU(word)) {
                prefix = word.substring(0, i);
                suffix = word.substring(i, word.length());
                break;
            } else if (containsQU(word)) {
                if (isAVowelExcludingU(word.charAt(i))) {
                    prefix = word.substring(0, i);
                    suffix = word.substring(i, word.length());
                    break;
                }
            } else if (secondLetterInTwoLetterWordContainsY(word)) {
                prefix = word.substring(0, i);
                suffix = word.substring(i, word.length());
            }
        }
        return Stream.of(suffix, prefix, "ay").collect(Collectors.joining());
    }
}
