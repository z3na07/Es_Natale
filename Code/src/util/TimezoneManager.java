package util;

public class TimezoneManager {
    public static int timezonePassed;
    public static final int maxTimezone = 3;

    public TimezoneManager(int maxTimezone) {
        this.maxTimezone = maxTimezone;
        this.timezonePassed = 0;
    }

    public boolean isTimeToChange() {
        return timezonePassed == 3;
    }

    /* =========================================
                  TIME ZONE PASSED
    * ==========================================*/

    public void incrementTimezonePassed() {
        incrementTimezonePassed(1);
    }

    public void incrementTimezonePassed(int n) {
        this.timezonePassed += n;
    }

    public void setTimezonePassed(int n) {
        this.timezonePassed = n;
    }
}
