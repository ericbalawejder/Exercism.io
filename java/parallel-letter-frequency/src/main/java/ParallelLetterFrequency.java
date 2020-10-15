import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private final String text;

    ParallelLetterFrequency(String text) {
        this.text = text;
    }

    Map<Integer, Integer> letterCounts() {
        return filter(text).chars()
                .parallel()
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(key -> key, value -> 1, Integer::sum),
                        Collections::unmodifiableMap));
    }

    private String filter(String text) {
        //https://stackoverflow.com/questions/30225552/regex-for-diacritics
        //[^a-zA-ZÀ-ž]
        return text.replaceAll(
                "[^A-zÀ-ÖØ-öø-įĴ-őŔ-žǍ-ǰǴ-ǵǸ-țȞ-ȟȤ-ȳɃɆ-ɏḀ-ẞƀ-ƓƗ-ƚƝ-ơƤ-ƥƫ-ưƲ-ƶẠ-ỿ]",
                "")
                .toLowerCase();
    }
}