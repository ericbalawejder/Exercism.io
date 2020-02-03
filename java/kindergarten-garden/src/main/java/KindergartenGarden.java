import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class KindergartenGarden {

    private final String garden;
    private final int newRowLocation;
    private static final int PLANTS_PER_STUDENT_PER_ROW = 2;
    private static final String[] DEFAULT_STUDENTS = {
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"
    };

    KindergartenGarden(String garden) {
        this.garden = garden;
        newRowLocation = garden.indexOf('\n') + 1;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();
        int studentPlantsIndex = Arrays.binarySearch(DEFAULT_STUDENTS, student) * PLANTS_PER_STUDENT_PER_ROW;

        for (int i = studentPlantsIndex; i < studentPlantsIndex + PLANTS_PER_STUDENT_PER_ROW; i++) {
            plants.add(Plant.getPlant(garden.charAt(i)));
        }
        for (int i = newRowLocation + studentPlantsIndex;
             i < newRowLocation + studentPlantsIndex + PLANTS_PER_STUDENT_PER_ROW; i++) {
            plants.add(Plant.getPlant(garden.charAt(i)));
        }
        return Collections.unmodifiableList(plants);
    }

}
