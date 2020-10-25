enum OrbitalPeriod {

    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132),
    SECONDS_IN_EARTH_YEAR(31557600);

    private final double earthYears;

    OrbitalPeriod(double earthYears) {
        this.earthYears = earthYears;
    }

    public double getOrbit() {
        return earthYears;
    }

}
