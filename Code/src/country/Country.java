package country;

public class Country {
    private String name;
    private long population;
    private double goodChilder;
    private String timeZone;

    public Country(String name, long population, double goodChilder, String timeZone) {
        this.name = name;
        this.population = population;
        this.goodChilder = goodChilder;
        this.timeZone = timeZone;
    }

    public long getPopulationOfGoodChilder() {
        Number n = population * goodChilder;
        return n.longValue();
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public double getGoodChilder() {
        return goodChilder;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
