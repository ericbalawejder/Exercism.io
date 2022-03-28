package utils;

public class Lasagna extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Lasagna";
    }

    public int expectedMinutesInOven() {
        try {
            return invokeMethod("expectedMinutesInOven", new Class[]{});
        } catch (Exception e) {
            return 0;
        }
    }

    public int remainingMinutesInOven(int actualMinutes) {
        try {
            return invokeMethod("remainingMinutesInOven", new Class[]{int.class}, actualMinutes);
        } catch (Exception e) {
            return 0;
        }
    }

    public int preparationTimeInMinutes(int amountLayers) {
        try {
            return invokeMethod("preparationTimeInMinutes", new Class[]{int.class}, amountLayers);
        } catch (Exception e) {
            return 0;
        }
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        try {
            return invokeMethod("totalTimeInMinutes", new Class[]{int.class, int.class}, amountLayers, actualMinutes);
        } catch (Exception e) {
            return 0;
        }
    }
}