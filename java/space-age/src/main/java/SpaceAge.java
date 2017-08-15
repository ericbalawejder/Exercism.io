// Given an age in seconds, calculate how old someone would be on:
class SpaceAge
{
    private final double seconds;
    private static final double secondsInEarthYear = 31557600;
    
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
        return seconds / secondsInEarthYear;
    }
    
    double onMercury()
    {
        return seconds / (secondsInEarthYear * 0.2408467);
    }

    double onVenus()
    {
        return seconds / (secondsInEarthYear * 0.61519726);
    }

    double onMars()
    {
        return seconds / (secondsInEarthYear * 1.8808158);
    }

    double onJupiter()
    {
        return seconds / (secondsInEarthYear * 11.862615);
    }

    double onSaturn()
    {
        return seconds / (secondsInEarthYear * 29.447498);
    }

    double onUranus()
    {
        return seconds / (secondsInEarthYear * 84.016846);
    }

    double onNeptune()
    {
        return seconds / (secondsInEarthYear * 164.79132);
    }
}
