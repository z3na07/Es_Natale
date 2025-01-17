import Util.Initialize;
import country.Country;
import country.CountryManager;
import reindeer.ReindeerTeam;

import javax.xml.transform.Source;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Initialize initialize = new Initialize(
                "src/data/files/World_Christmas_Schedule.json",
                "src/data/files/reindeer.json"
        );
        CountryManager countryManager = new CountryManager(initialize.getCountryArrayList());
        ReindeerTeam reindeerTeam = new ReindeerTeam(initialize.getReindeerArrayList());
        SantaClaus santaClaus = new SantaClaus(reindeerTeam);

        for (int i = -12; i < 15; i++) {
            String timezone = CountryManager.getTimezoneString(i);

            ArrayList<Country> countriesInTimezone = countryManager.getCountriesInTimezone(timezone);

            if (countriesInTimezone.isEmpty()) {
                break;
            }


        }

        System.out.println();
    }
}
