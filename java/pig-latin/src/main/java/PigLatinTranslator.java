import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    public static void main(String... args) {
        PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();
        System.out.println(pigLatinTranslator.pigLatin("wzxqurjik"));
        System.out.println(pigLatinTranslator.pigLatin("my"));
        //System.out.println(pigLatinTranslator.pigLatin("yttria"));
        //System.out.println(pigLatinTranslator.translate("rhythm deez nuts your chin"));
    }

    String translate(String phrase) {
        String[] words = phrase.replaceAll("[^\\w]", " ").split("\\s+");
        return Arrays.stream(words)
                .map(word -> pigLatin(word))
                .collect(Collectors.joining(" "));
    }

    String pigLatin(String word) {
        //Pattern vowel = Pattern.compile("^([aeiou]|y[^aeiou]|xr)");
        //Pattern consonants = Pattern.compile("^([^aeiou]?qu|[^aeiouy]+|y(?=[aeiou]))");
        Pattern vowel = Pattern.compile("^([aeiou]|yt|xr)");
        Pattern consonants = Pattern.compile("^([^aeiou]*?qu|[^aeiouy]+|y(?=[aeiou])|[^aeiou]+)");

        String pigLatin = "";

        if (vowel.matcher(word).find()) {
            return Stream.of(word, "ay").collect(Collectors.joining());
        }
        else {
            Matcher matches = consonants.matcher(word);
            if (matches.find()) {
                pigLatin = word.substring(matches.end()) + matches.group();
                //System.out.println(matches.end() + "  " + matches.group());
            }
        }
        return Stream.of(pigLatin, "ay").collect(Collectors.joining());
    }
}
