import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCount {

    private static final Pattern WORD = Pattern.compile("\\b[\\w']+\\b");

    Map<String, Integer> phrase(String phrase) {
        final Matcher matcher = WORD.matcher(phrase.toLowerCase());

        return Stream.generate(matcher::find)
                .takeWhile(found -> found)
                .map(word -> matcher.group())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    Map<String, Integer> phrase2(String sentence) {

        String[] words = sentence.replaceAll("[^a-zA-Z0-9\\'\\s]|\\B'|'\\B", " ")
                .toLowerCase()
                .trim()
                .split("\\s+");

        return Stream.of(words)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(key -> key, value -> 1, Integer::sum),
                        Collections::unmodifiableMap));
    }

}
