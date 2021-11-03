public class Lasagna {

    private static final int MINUTES_TO_COOK = 40;

    int expectedMinutesInOven() {
        return MINUTES_TO_COOK;
    }

    int remainingMinutesInOven(int minutesInOven) {
        return expectedMinutesInOven() - minutesInOven;
    }

    int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * 2;
    }

    int totalTimeInMinutes(int numberOfLayers, int minutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + minutesInOven;
    }

}
