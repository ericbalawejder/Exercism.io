// Given an seconds in seconds, calculate how old someone would be on:
public class SpaceAge
{
    private enum ORBITAL_PERIOD
    {
        SECONDS_IN_EARTH_YEAR(31557600),
        // Orbital period values represented in Earth years.
        MERCURY(0.2408467), 
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private final double earthYears;
        ORBITAL_PERIOD(double earthYears)
        {
            this.earthYears = earthYears;
        }
        public double getOrbit()
        {
            return earthYears;
        }
    }

    private final Double seconds;

    SpaceAge(double seconds)
    {
        this.seconds = seconds;
    }

    double getSeconds()
    {
        return seconds;
    }

    double onEarth()
    {
        return getSeconds() / ORBITAL_PERIOD.SECONDS_IN_EARTH_YEAR.getOrbit();
    }

    double onMercury()
    {
        return onEarth() / ORBITAL_PERIOD.MERCURY.getOrbit();
    }

    double onVenus()
    {
        return onEarth() / ORBITAL_PERIOD.VENUS.getOrbit();
    }

    double onMars()
    {
        return onEarth() / ORBITAL_PERIOD.MARS.getOrbit();
    }

    double onJupiter()
    {
        return onEarth() / ORBITAL_PERIOD.JUPITER.getOrbit();
    }	

    double onSaturn()
    {
        return onEarth() / ORBITAL_PERIOD.SATURN.getOrbit();
    }

    double onUranus()
    {
        return onEarth() / ORBITAL_PERIOD.URANUS.getOrbit();
    }

    double onNeptune()
    {
        return onEarth() / ORBITAL_PERIOD.NEPTUNE.getOrbit();
    }
}
