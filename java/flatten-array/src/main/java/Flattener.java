import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Flattener {

    List<Object> flatten(List<?> nestedList) {
        return flattenToStream(nestedList)
                .filter(element -> element != null)
                .collect(Collectors.toList());
    }

    private Stream<Object> flattenToStream(List<?> nestedList) {
        return nestedList.stream()
                .flatMap(element -> element instanceof List ?
                    flattenToStream( (List<?>) element) : Stream.of(element));
    }
}
