import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

class School {
    private final SortedSet<KeyValuePair> students = new TreeSet<>();

    void add(final String name, final int grade) {
        students.add(new KeyValuePair(name, grade));
    }

    List<String> roster() {
        return students.stream()
                .map(KeyValuePair::getKey)
                .collect(Collectors.toUnmodifiableList());
    }

    List<String> grade(final int grade) {
        return students.stream()
                .filter(keyValuePair -> keyValuePair.getValue() == grade)
                .map(KeyValuePair::getKey)
                .collect(Collectors.toUnmodifiableList());
    }
}
