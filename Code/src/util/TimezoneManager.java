package util;

/**
 * Manages the count of time zones passed.
 * <p>
 * This class keeps track of the number of time zones crossed
 * and checks when it is time to change the time zone.
 * </p>
 */
public class TimezoneManager {
    public int timezonePassed;
    public final int maxTimezone;

    /**
     * Constructor for the TimezoneManager class.
     *
     * @param maxTimezone the maximum number of time zones that can be crossed
     */
    public TimezoneManager(int maxTimezone) {
        this.maxTimezone = maxTimezone;
        this.timezonePassed = 0;
    }

    /**
     * Checks if it is time to change the time zone.
     *
     * @return true if the number of time zones crossed is 3, otherwise false
     */
    public boolean isTimeToChange() {
        return timezonePassed == 3;
    }

    /* =========================================
                  TIME ZONE PASSED
    * ==========================================*/

    /**
     * Increments the number of time zones crossed by 1.
     */
    public void incrementTimezonePassed() {
        incrementTimezonePassed(1);
    }

    /**
     * Increments the number of time zones crossed by a specified amount.
     *
     * @param n the number of time zones to add
     */
    public void incrementTimezonePassed(int n) {
        this.timezonePassed += n;
    }

    /**
     * Sets the number of time zones crossed to a specific value.
     *
     * @param n the new value for the time zones counter
     */
    public void setTimezonePassed(int n) {
        this.timezonePassed = n;
    }
}
