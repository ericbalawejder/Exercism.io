import java.util.Map;
import java.util.LinkedHashMap;

class ResistorColor {

    private static final Map<String, Integer> resistor = new LinkedHashMap<>();
    static {
        resistor.put("black", 0);
        resistor.put("brown", 1);
        resistor.put("red", 2);
        resistor.put("orange", 3);
        resistor.put("yellow", 4);
        resistor.put("green", 5);
        resistor.put("blue", 6);
        resistor.put("violet", 7);
        resistor.put("grey", 8);
        resistor.put("white", 9);
    }

    int colorCode(String color) {
        return resistor.get(color);
    }

    String[] colors() {
        return resistor.keySet().toArray(new String[resistor.keySet().size()]);
    }

}
