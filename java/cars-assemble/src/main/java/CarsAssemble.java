import java.util.Map;

public class CarsAssemble {

    private final static int HOURLY_PRODUCTION_RATE = 221;
    private final static Map<Integer, Double> SUCCESS_RATE = Map.ofEntries(
            Map.entry(0, 1.0),
            Map.entry(1, 1.0),
            Map.entry(2, 1.0),
            Map.entry(3, 1.0),
            Map.entry(4, 1.0),
            Map.entry(5, 0.9),
            Map.entry(6, 0.9),
            Map.entry(7, 0.9),
            Map.entry(8, 0.9),
            Map.entry(9, 0.8),
            Map.entry(10, 0.77)
    );

    public double productionRatePerHour(int speed) {
        return speed * HOURLY_PRODUCTION_RATE * SUCCESS_RATE.get(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return  (int) productionRatePerHour(speed) / 60;
    }

}
