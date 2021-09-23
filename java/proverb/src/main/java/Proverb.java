import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        final String lastLine = words.length > 0 ? "And all for the want of a " + words[0] + "." : "";
        return IntStream.range(0, words.length - 1)
                .mapToObj(i -> "For want of a " + words[i] + " the " + words[i + 1] + " was lost.\n")
                .collect(Collectors.joining()) + lastLine;
    }

}
