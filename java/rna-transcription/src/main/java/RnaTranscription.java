import java.util.Map;
import java.util.stream.Collector;

public class RnaTranscription {

    private static final Map<Character, Character> RNA_TRANSCRIPTION = Map.of(
            'C', 'G', 'G', 'C', 'T', 'A', 'A', 'U');

     String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(c -> (char) c)
                .map(c -> RNA_TRANSCRIPTION.getOrDefault(c, c))
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }

}
