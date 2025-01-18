import Util.GiftManager;
import Util.Initialize;
import country.Country;
import country.CountryManager;
import reindeer.ReindeerTeam;

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

            // if there are no countries in timezone break
            if (countriesInTimezone.isEmpty()) {
                break;
            }

            // Get how many gifts santa have to deliver in the specific timezone
            for (Country c : countriesInTimezone) {
                GiftManager.giftsToDeliver += c.getPopulationOfGoodChilder();
            }

            if (GiftManager.giftsToDeliver <= GiftManager.maxGift) {
                santaClaus.addTotalGiftsDelivered(GiftManager.giftsToDeliver);
                GiftManager.clear();
            } else {
                // cycle until it's done
            }
        }

        System.out.println("PROGRAM FINISHED");
    }
}
