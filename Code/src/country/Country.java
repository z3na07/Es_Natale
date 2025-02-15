package country;

/**
 * Class country that is called when we create a new country, in the class we hava eall the methods we need like the get e sets methods and the constructor
 */
public class Country {
    private String name;
    private long population;
    private double goodChildren;
    private String timeZone;


    /**
     * constructor of the class, we call itr when we want to create a new Object country 
     * 
     * @param name is te name of the conutry that we are creating
     * @param population is the total puplation of the country
    * @param goodChilder is the total in percent of the amount of good children in the country
    * @param timeZone is the country's time zone
    */
    public Country(String name, long population, double goodChildren, String timeZone) {
        this.population = population;
        this.goodChildren = goodChildren;
        this.timeZone = timeZone;
    }


    /**
    * this methods calculate the population of good chldren in that specific country
    * 
    * @return n.longvaue() this methods returns the amount of good children expressed in percent
    */
    public long getPopulationOfgoodChildren() {
        Number n = population * goodChildren;
        return n.longValue();
    }

    /**
     * get method of the variable name
     * 
     * @return it returns the name of the country that we selected
     */
    public String getName() {
        return name;
    }

    /**
     * method get of the variable population 
     * 
     * @return this method returns the total population ofn the country that we have selected
     */
    public long getPopulation() {
        return population;
    }

    /**
     * method het of the variabler goodChilder 
     * 
     * @return this method returns the total amount of goodl children in a specific country
     */
    public double getgoodChildren() {
        return goodChildren;

    }

    /**
     * method get of tha variabvle timeZone
     * 
     * @return this methods returns the time zone where is located a specific country
     */
    public String getTimeZone() {
        return timeZone;
    }
}
