import java.time.LocalTime;

public class TimeInterval {
    private LocalTime start;
    private LocalTime end;

    public TimeInterval(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlapsWith(TimeInterval other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }
}
