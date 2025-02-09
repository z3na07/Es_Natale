package util;

/**
 * Manages the count of time zones passed.
 * <p>
 * This class keeps track of the number of time zones crossed
 * and checks when it is time to change the time zone.
 * </p>
 */
public class TimezoneManager {
    private int timezonePassed;
    private int timezoneToChange;
    private final int maxTimezone;
    private int currentTimezone;

    /**
     * Constructor for the TimezoneManager class.
     *
     * @param maxTimezone the maximum number of time zones that can be crossed
     */
    public TimezoneManager(int maxTimezone) {
        this.maxTimezone = maxTimezone;
        this.timezonePassed = 0;
        this.timezoneToChange = 0;
    }

    /**
     * Checks if it is time to change the time zone.
     *
     * @return true if the number of time zones crossed is 3, otherwise false
     */
    public boolean isTimeToChange() {
        if (timezoneToChange == 3) {
            timezoneToChange = 0;
            return true;
        }

        return false;
    }

    public static String getTimezoneString(int i) {
        String timeZone = "";

        // Transform the index in to time zone annotation
        if (i < 0) {
            if (i*(-1) < 10) {
                timeZone = String.format("UTC-0%d:00", i*(-1));
            } else {
                timeZone = String.format("UTC%d:00", i);
            }
        } else {
            if (i < 10) {
                timeZone = String.format("UTC+0%d:00", i);
            } else {
                timeZone = String.format("UTC+%d:00", i);
            }
        }

        return timeZone;
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
        this.timezoneToChange += n;
    }

    /**
     * Sets the number of time zones crossed to a specific value.
     *
     * @param n the new value for the time zones counter
     */
    public void setTimezonePassed(int n) {
        this.timezonePassed = n;
    }

    public int getTimezonePassed() {
        return timezonePassed;
    }

    /* =========================================
                 CURRENT TIME ZONE
    * ========================================== */

    public void setCurrentTimezone(int t) {
        currentTimezone = t;
    }

    public String getCurrentTimezoneString() {
        return getTimezoneString(currentTimezone);
    }

    public int getCurrentTimezoneInteger() {
        return currentTimezone;
    }
}
