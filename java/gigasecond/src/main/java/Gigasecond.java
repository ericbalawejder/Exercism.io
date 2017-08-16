// Calculate the moment when someone has lived for 10^9 seconds.
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond
{
    private final LocalDateTime now;
    private final long GIGASECOND = 1_000_000_000L;
    
    Gigasecond(LocalDate birthDate)
    {
        this.now = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime)
    {
        this.now = birthDateTime;
    }

    LocalDateTime getDate()
    {
        // plusSeconds(long seconds)
        return now.plusSeconds(GIGASECOND);
    }
}
