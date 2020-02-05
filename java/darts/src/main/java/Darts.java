class Darts {

    private final double dart;

    Darts(double x, double y) {
        this.dart = Math.hypot(x, y);
    }

    int score() {
        return onTarget(getDart());
    }

    double getDart() {
        return this.dart;
    }

    private int onTarget(double dart) {
        if (dart > 10) {
            return 0;
        } else if (dart > 5) {
            return 1;
        } else if (dart > 1) {
            return 5;
        } else {
            return 10;
        }
    }

}
