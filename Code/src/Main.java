import Util.Initialize;
import country.CountryManager;

public class Main {
    public static void main(String[] args) {
        Initialize initialize = new Initialize(
                "src/data/files/World_Christmas_Schedule.json",
                "src/data/files/reindeer.json");
        CountryManager countryManager = new CountryManager(initialize.getCountryArrayList());

        System.out.println();
    }
}
