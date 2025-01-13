import Util.Initialize;
import country.Country;
import country.CountryManager;

import java.util.Locale;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Initialize initialize = new Initialize("src/data/files/World_Christmas_Schedule.json");
        CountryManager countryManager = new CountryManager(initialize.getCountryArrayList());

        System.out.println();
    }
}
