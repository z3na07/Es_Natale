package reindeer;

import java.util.ArrayList;

/**
 * This class deals with the reindeers
 * Manage the active and resting team.
 */
public class ReindeerTeam {
    private ArrayList<Reindeer> reindeerArrayList;
    private ArrayList<Reindeer> activeTeam;
    private ArrayList<Reindeer> restingTeam;
    private Rudolph rudolph;

    /**
     * When instantiated the ReindeerTeam:
     * 1. take all the reindeer as a list
     * 2. create an instance of Rudolph
     * 3. Load teams
     */
    public ReindeerTeam(ArrayList<Reindeer> reindeerArrayList) {
        this.reindeerArrayList = reindeerArrayList;
        this.rudolph = new Rudolph();
        loadTeams();
    }

    /**
     * This method divide the reindeer in two teams and add rudoplh on the active team
     */
    private void loadTeams() {
        activeTeam = new ArrayList<>(reindeerArrayList.subList(3, 6));
        restingTeam = new ArrayList<>(reindeerArrayList.subList(0, 3));

        activeTeam.forEach(r -> r.setActive(true));

        reindeerArrayList.clear();
        reindeerArrayList.addAll(activeTeam);
        reindeerArrayList.addAll(restingTeam);

        activeTeam.add(rudolph);
    }

    /**
     * This method set the variable {@code active} in {@class Reindeer} 
     * as the opposite of its current state.
     * Then add rudolph to the active team.
     */
    public void switchTeams() {
        reindeerArrayList.forEach(r -> r.setActive(!r.isActive()));
        orderTeams();
        activeTeam.add(rudolph);
    }

    /**
     * This methods 
     */
    private void orderTeams() {
        activeTeam.clear();
        restingTeam.clear();

        reindeerArrayList.forEach(r -> {
            if (r.isActive()) {
                activeTeam.add(r);
            } else {
                restingTeam.add(r);
            }
        });
    }

    /**
     * 
     */
    public ArrayList<Reindeer> getActiveTeam() {
        return activeTeam;
    }

    /**
     * 
     */
    public ArrayList<Reindeer> getRestingTeam() {
        return restingTeam;
    }
}
