import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSet<T extends Comparable<? super T>> {

    private final Map<Integer, T> elements;

    CustomSet(List<? extends T> elements) {
        this.elements = elements.stream()
                .distinct()
                .collect(Collectors.toMap(Object::hashCode, Function.identity()));
    }

    void add(T element) {
        if (!contains(element)) {
            elements.put(element.hashCode(), element);
        }
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    boolean contains(T element) {
        return elements.containsKey(element.hashCode());
    }

    boolean isSubset(CustomSet<T> otherCustomSet) {
        return elements.values().containsAll(otherCustomSet.elements.values());
    }

    boolean isDisjoint(CustomSet<T> otherCustomSet) {
        return otherCustomSet.elements.values()
                .stream()
                .noneMatch(elements.values()::contains);
    }

    CustomSet<T> getIntersection(CustomSet<T> otherCustomSet) {
        return new CustomSet<>(elements
                .values()
                .stream()
                .filter(otherCustomSet::contains)
                .collect(Collectors.toUnmodifiableList()));
    }

    CustomSet<T> getDifference(CustomSet<T> otherCustomSet) {
        return new CustomSet<>(elements
                .values()
                .stream()
                .filter(e -> !otherCustomSet.contains(e))
                .collect(Collectors.toUnmodifiableList()));
    }

    CustomSet<T> getUnion(CustomSet<T> otherCustomSet) {
        return new CustomSet<>(
                Stream.concat(elements.values().stream(), otherCustomSet.elements.values().stream())
                        .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public boolean equals(Object otherCustomSet) {
        if (otherCustomSet instanceof CustomSet<?>) {
            return ((CustomSet<?>) otherCustomSet).elements.keySet().equals(elements.keySet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return elements.values().toString();
    }

}
