import Util.Logger;
import reindeer.ReindeerTeam;

public class SantaClaus {
    private long totalGiftsDelivered;
    private int reindeerSwitches;
    private ReindeerTeam reindeerTeam;

    public SantaClaus(ReindeerTeam reindeerTeam) {
        this.totalGiftsDelivered = 0;
        this.reindeerSwitches = 0;
        this.reindeerTeam = reindeerTeam;
    }

    public void switchTeam() {
        reindeerTeam.switchTeams();
        reindeerSwitches++;
        Logger.logReindeerMessage(reindeerSwitches);
    }
}
