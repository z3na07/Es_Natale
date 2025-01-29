package reindeer;

import java.util.ArrayList;

public class ReindeerTeam {
    private ArrayList<Reindeer> reindeerArrayList;
    private ArrayList<Reindeer> activeTeam;
    private ArrayList<Reindeer> restingTeam;
    private Rudolph rudolph;

    public ReindeerTeam(ArrayList<Reindeer> reindeerArrayList) {
        this.reindeerArrayList = reindeerArrayList;
        this.rudolph = new Rudolph();
        loadTeams();
    }

    private void loadTeams() {
        activeTeam = new ArrayList<>(reindeerArrayList.subList(3, 6));
        restingTeam = new ArrayList<>(reindeerArrayList.subList(0, 3));

        activeTeam.forEach(r -> r.setActive(true));

        reindeerArrayList.clear();
        reindeerArrayList.addAll(activeTeam);
        reindeerArrayList.addAll(restingTeam);

        activeTeam.add(rudolph);
    }

    public void switchTeams() {
        reindeerArrayList.forEach(r -> r.setActive(!r.isActive()));
        orderTeams();
        activeTeam.add(rudolph);
    }

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
}
