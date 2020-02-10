import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RnaTranscription {

    private static final Map<Character, Character> RNA_TRANSCRIPTION;
    static {
        Map<Character, Character> dnaToRna = new HashMap<>();
        dnaToRna.put('C', 'G');
        dnaToRna.put('G', 'C');
        dnaToRna.put('T', 'A');
        dnaToRna.put('A', 'U');
        RNA_TRANSCRIPTION = Collections.unmodifiableMap(dnaToRna);
    }

     String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(c -> (char) c)
                .map(c -> RNA_TRANSCRIPTION.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
