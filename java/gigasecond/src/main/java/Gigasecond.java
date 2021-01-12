import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final LocalDateTime now;
    private static final long GIGASECOND = 1_000_000_000L;

    Gigasecond(LocalDate birthDate) {
        this.now = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.now = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return now.plusSeconds(GIGASECOND);
    }
    
}
