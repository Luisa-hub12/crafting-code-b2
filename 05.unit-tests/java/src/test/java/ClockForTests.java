import unit.tests.intro.Clock;

import java.time.LocalTime;

public class ClockForTests implements Clock {
    private final int hour;
    private final int minute;

    public ClockForTests(int hour) {
        this(hour, 0);
    }

    public ClockForTests(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public LocalTime now() {
        return LocalTime.of(hour, minute);
    }
}
