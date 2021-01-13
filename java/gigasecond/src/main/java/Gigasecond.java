import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final Duration GIGASECOND = Duration.ofSeconds(1_000_000_000);
    private final LocalDateTime now;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.now = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return now.plus(GIGASECOND);
    }
    
}
