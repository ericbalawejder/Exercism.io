import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    String translate(String phrase) {
        String[] words = phrase.replaceAll("[^\\w]", " ").split("\\s+");
        return Arrays.stream(words)
                .map(word -> pigLatin(word))
                .collect(Collectors.joining(" "));
    }

    String pigLatin(String word) {
        Pattern beginsWithVowel = Pattern.compile("^([aeiou]|yt|xr)");
        Pattern beginsWithConsonant = Pattern.compile(
                "^([^aeiou]*?qu|[^aeiouy]+|y(?=[aeiou])|[^aeiou]+)");

        Optional<String> prefix = Optional.empty();
        Optional<String> suffix = Optional.empty();

        if (beginsWithVowel.matcher(word).find()) {
            return Stream.of(word, "ay").collect(Collectors.joining());
        }
        else {
            Matcher matches = beginsWithConsonant.matcher(word);
            if (matches.find()) {
                prefix = Optional.of(matches.group());
                suffix = Optional.of(word.substring(matches.end()));
            }
        }
        return Stream.of(suffix.orElse(""), prefix.orElse(""), "ay")
                .collect(Collectors.joining());
    }

}
