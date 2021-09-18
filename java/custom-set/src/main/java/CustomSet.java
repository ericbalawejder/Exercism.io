import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomSet<T> {

    private final Map<Integer, T> elements;

    CustomSet(List<T> elements) {
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

    boolean isSubset(CustomSet<T> other) {
        for (Map.Entry<Integer, T> entry : other.elements.entrySet()) {
            if (!contains(entry.getValue()))
                return false;
        }
        return true;
    }

    boolean isDisjoint(CustomSet<T> other) {
        for (Map.Entry<Integer, T> entry : other.elements.entrySet()) {
            if (contains(entry.getValue()))
                return false;
        }
        return true;
    }

    CustomSet<T> getIntersection(CustomSet<T> other) {
        return new CustomSet<>(elements
                .values()
                .stream()
                .filter(other::contains)
                .collect(Collectors.toUnmodifiableList()));
    }

    CustomSet<T> getDifference(CustomSet<T> other) {
        return new CustomSet<>(elements
                .values()
                .stream()
                .filter(e -> !other.contains(e))
                .collect(Collectors.toUnmodifiableList()));
    }

    CustomSet<T> getUnion(CustomSet<T> other) {
        final List<T> values = new ArrayList<>(elements.values());
        values.addAll(other.elements.values());
        return new CustomSet<>(values);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CustomSet<?>) {
            return ((CustomSet<?>) other).elements.keySet().equals(elements.keySet());
        }
        return false;
    }

    @Override
    public String toString() {
        return elements.values().toString();
    }

}
