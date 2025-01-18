package reindeer;

public class Reindeer {
    private String name;
    private boolean isActive;

    public Reindeer(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
