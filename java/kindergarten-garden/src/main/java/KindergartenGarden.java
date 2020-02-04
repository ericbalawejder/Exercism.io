import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class KindergartenGarden {

    private final char[][] cups;
    private final static List<String> STUDENTS = List.of(
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"
    );

    KindergartenGarden(String garden) {
        cups = Arrays.stream(garden.split("\n"))
                .map(row -> row.toCharArray())
                .toArray(char[][]::new);
    }

    List<Plant> getPlantsOfStudent(String student) {
        int cup1 = STUDENTS.indexOf(student) * 2;
        int cup2 = cup1 + 1;

        return Arrays.stream(cups)
                .map(it -> List.of(it[cup1], it[cup2]))
                .flatMap(it -> it.stream())
                .map(Plant::getPlant)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), Collections::unmodifiableList));
    }

}
