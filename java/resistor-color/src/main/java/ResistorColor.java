import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;

class ResistorColor {

    private static final Map<String, Integer> RESISTORS;
    static {
        Map<String, Integer> resistorColor = new LinkedHashMap<>();
        resistorColor.put("black", 0);
        resistorColor.put("brown", 1);
        resistorColor.put("red", 2);
        resistorColor.put("orange", 3);
        resistorColor.put("yellow", 4);
        resistorColor.put("green", 5);
        resistorColor.put("blue", 6);
        resistorColor.put("violet", 7);
        resistorColor.put("grey", 8);
        resistorColor.put("white", 9);
        RESISTORS = Collections.unmodifiableMap(resistorColor);
    }

    int colorCode(String color) {
        return RESISTORS.get(color);
    }

    String[] colors() {
        return RESISTORS.keySet().toArray(new String[RESISTORS.keySet().size()]);
    }

}
