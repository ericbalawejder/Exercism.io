import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

class RaindropConverter {
    private static final SortedMap<Integer, String> RAINDROPS;

    static {
        final SortedMap<Integer, String> drops = new TreeMap<>();
        drops.put(3, "Pling");
        drops.put(5, "Plang");
        drops.put(7, "Plong");
        RAINDROPS = Collections.unmodifiableSortedMap(drops);
    }

    String convert(final int number) {
        return RAINDROPS.entrySet()
                .stream()
                .filter(drop -> number % drop.getKey() == 0)
                .map(drop -> drop.getValue())
                .reduce(String::concat)
                .orElse(Integer.toString(number));
    }
}