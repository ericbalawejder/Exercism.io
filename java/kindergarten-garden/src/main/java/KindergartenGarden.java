import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

// Given a diagram, determine which plants each child in the kindergarten class is
// responsible for.
public class KindergartenGarden
{
    public static void main(String[] args)
    {
        System.out.println("Boys have penises and girls have vaginas");
        System.out.println(students);
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String[] rows = plants.split("\n");
        String firstRowOfPlants = rows[0];
        String secondRowOfPlants = rows[1];
        System.out.println(firstRowOfPlants);
        System.out.println(secondRowOfPlants);
    }

    private static Map<String, Integer> studentStartingIndex = new HashMap<>();
    static
    {
        studentStartingIndex.put("Alice", 0);
        studentStartingIndex.put("Bob", 2);
        studentStartingIndex.put("Charlie", 4);
        studentStartingIndex.put("David", 6);
        studentStartingIndex.put("Eve", 8);
        studentStartingIndex.put("Fred", 10);
        studentStartingIndex.put("Ginny", 12);
        studentStartingIndex.put("Harriet", 14);
        studentStartingIndex.put("Ileana", 16);
        studentStartingIndex.put("Joseph", 18);
        studentStartingIndex.put("Kincaid", 20);
        studentStartingIndex.put("Larry", 22);
    }

    static Set<String> students = new TreeSet<>(studentStartingIndex.keySet());
    private String garden;

    public KindergartenGarden(String garden, String[] students)
    {
        
    }

    public KindergartenGarden(String garden)
    {
        this.garden = garden;
    }

    private List<Plant> getPlantsOfStudent(String student)
    {
        List<Plant> plants = new ArrayList<>();
        
        return plants;
    }
}
