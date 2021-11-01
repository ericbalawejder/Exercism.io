import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    int[] getLastWeek() {
        return birdsPerDay.clone();
    }

    int getToday() {
        return birdsPerDay.length == 0 ? 0 : this.birdsPerDay[birdsPerDay.length - 1];
    }

    void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay)
                .anyMatch(i -> i == 0);
    }

    int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(birdsPerDay)
                .limit(numberOfDays)
                .reduce(Integer::sum)
                .orElseThrow(IllegalArgumentException::new);
    }

    int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay)
                .filter(i -> i >= 5)
                .count();
    }

}
