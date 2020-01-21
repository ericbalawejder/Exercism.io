import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class ResistorColorDuo {

    private static final Map<String, String> RESISTORS;
    static {
        Map<String, String> resistorColor = new HashMap<>();
        resistorColor.put("black", "0");
        resistorColor.put("brown", "1");
        resistorColor.put("red", "2");
        resistorColor.put("orange", "3");
        resistorColor.put("yellow", "4");
        resistorColor.put("green", "5");
        resistorColor.put("blue", "6");
        resistorColor.put("violet", "7");
        resistorColor.put("grey", "8");
        resistorColor.put("white", "9");
        RESISTORS = Collections.unmodifiableMap(resistorColor);
    }

    int value(String[] colors) {
        return Integer.parseInt(Arrays.stream(colors)
                .filter(s -> RESISTORS.containsKey(s))
                .map(s -> RESISTORS.get(s))
                .limit(2)
                .collect(Collectors.joining()));
    }

}
