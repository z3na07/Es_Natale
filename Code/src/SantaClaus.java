import Util.Logger;
import reindeer.ReindeerTeam;

public class SantaClaus {
    private long totalGiftsDelivered;
    private int timezonePassed;
    private int reindeerSwitches;
    private ReindeerTeam reindeerTeam;

    public SantaClaus(ReindeerTeam reindeerTeam) {
        this.totalGiftsDelivered = this.timezonePassed = this.reindeerSwitches = 0;
        this.reindeerTeam = reindeerTeam;
    }

    public void switchTeam() {
        reindeerTeam.switchTeams();
        reindeerSwitches++;
        Logger.logReindeerMessage(reindeerSwitches);
    }

    public long getTotalGiftsDelivered() {
        return totalGiftsDelivered;
    }

    public void addTotalGiftsDelivered(long giftsToAdd) {
        this.totalGiftsDelivered += totalGiftsDelivered;
    }

    public int getTimezonePassed() {
        return timezonePassed;
    }

    public void setTimezonePassed(int timezonePassed) {
        this.timezonePassed = timezonePassed;
    }

    public int getReindeerSwitches() {
        return reindeerSwitches;
    }
}
