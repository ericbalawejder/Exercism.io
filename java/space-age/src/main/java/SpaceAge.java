class SpaceAge {

    private final Double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return getSeconds() / OrbitalPeriod.SECONDS_IN_EARTH_YEAR.getOrbit();
    }

    double onMercury() {
        return onEarth() / OrbitalPeriod.MERCURY.getOrbit();
    }

    double onVenus() {
        return onEarth() / OrbitalPeriod.VENUS.getOrbit();
    }

    double onMars() {
        return onEarth() / OrbitalPeriod.MARS.getOrbit();
    }

    double onJupiter() {
        return onEarth() / OrbitalPeriod.JUPITER.getOrbit();
    }

    double onSaturn() {
        return onEarth() / OrbitalPeriod.SATURN.getOrbit();
    }

    double onUranus() {
        return onEarth() / OrbitalPeriod.URANUS.getOrbit();
    }

    double onNeptune() {
        return onEarth() / OrbitalPeriod.NEPTUNE.getOrbit();
    }

}
