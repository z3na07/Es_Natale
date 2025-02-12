package reindeer;

/**
 * class reindeer, this class is used when we want to create a new object Reindeer
 */
public class Reindeer {
    private String name;
    private boolean isActive;

    /**
     * contructor of the class reindeer
     * 
     * @param name is the name of the reindeer
     * @param isActive is a boolean variable that says if the reindeer is active/in work or no
     */
    public Reindeer(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    /**
     * get method of the variable isActive
     * 
     * @return it returns the value of the variable, its true or false
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * set method of the variable isActive, it sets the value that we entered as the current value of the variable
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Override of the method toString, we do that because we want the method to print in a different way 
     * 
     * @return it returns the String that is shown at video with the name and all the booelan variable of the reindeer 
     */
    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
