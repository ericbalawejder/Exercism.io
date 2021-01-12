import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    String translate(String phrase) {
        final String[] words = phrase.replaceAll("[^\\w]", " ")
                .split("\\s+");

        return Arrays.stream(words)
                .map(this::pigLatin)
                .collect(Collectors.joining(" "));
    }

    String pigLatin(String word) {
        Pattern beginsWithVowel = Pattern.compile("^([aeiou]|yt|xr)");
        Pattern beginsWithConsonant = Pattern.compile(
                "^([^aeiou]*?qu|[^aeiouy]+|y(?=[aeiou])|[^aeiou]+)");

        if (beginsWithVowel.matcher(word).find()) {
            return String.join("", word, "ay");
        } else {
            Matcher matches = beginsWithConsonant.matcher(word);
            Optional<String> prefix = Optional.empty();
            Optional<String> suffix = Optional.empty();
            if (matches.find()) {
                prefix = Optional.of(matches.group());
                suffix = Optional.of(word.substring(matches.end()));
            }
            return String.join("", suffix.orElse(""), prefix.orElse(""), "ay");
        }
    }
}
