import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        return old.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toUnmodifiableMap(
                        String::toLowerCase, s -> old.entrySet().stream()
                        .filter(entry -> entry.getValue().contains(s))
                        .map(Map.Entry::getKey)
                        .findFirst().get()));
    }
}
