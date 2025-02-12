package country;

public class Country {
    private String name;
    private long population;
    private double goodChildren;
    private String timeZone;

    public Country(String name, long population, double goodChildren, String timeZone) {
        this.name = name;
        this.population = population;
        this.goodChildren = goodChildren;
        this.timeZone = timeZone;
    }

    public long getPopulationOfgoodChildren() {
        Number n = population * goodChildren;
        return n.longValue();
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public double getgoodChildren() {
        return goodChildren;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
