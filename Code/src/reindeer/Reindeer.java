package reindeer;

public class Reindeer {
    private String name;
    private boolean isRudolph;
    private boolean isActive;

    public Reindeer(String name, boolean isRudolph, boolean isActive) {
        this.name = name;
        this.isRudolph = isRudolph;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", isRudolph=" + isRudolph +
                ", isActive=" + isActive +
                '}';
    }
}
