import util.GiftManager;
import util.Initialize;
import country.Country;
import country.CountryManager;
import reindeer.ReindeerTeam;
import util.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Initialize initialize = new Initialize(
                "src/data/files/World_Christmas_Schedule.json",
                "src/data/files/reindeer.json"
        );
        CountryManager countryManager = new CountryManager(initialize.getCountryArrayList());
        ReindeerTeam reindeerTeam = new ReindeerTeam(initialize.getReindeerArrayList());
        SantaClaus santaClaus = new SantaClaus(reindeerTeam);

        Scanner scanner = new Scanner(System.in);

        for (int i = -12; i < 15; i++) {
        
            // Check if the time zone just passed, it is the third time zone passed
            // TimezoneManager.timezonePassed > TimezoneManager.maxTimezone

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

            if (GiftManager.giftsToDeliver <= GiftManager.giftsUntilStop) {
                santaClaus.addTotalGiftsDelivered(GiftManager.giftsToDeliver);
                GiftManager.giftsUntilStop -= GiftManager.giftsToDeliver;
            } else {
                // cycle until it's done
                while (GiftManager.giftsToDeliver > GiftManager.giftsUntilStop) {
                    // deliver - stop
                    GiftManager.giftsToDeliver -= GiftManager.giftsUntilStop;
                    // santa.delivered + stop
                    santaClaus.addTotalGiftsDelivered(GiftManager.giftsUntilStop);
                    // Ask to continue
                    System.out.println("Premere invio per continuare");
                    scanner.nextLine();

                    GiftManager.resetGiftUntilStop();
                }

                // Check if there are gift left
                if (GiftManager.giftsToDeliver > 0 && GiftManager.giftsToDeliver < GiftManager.maxGift) {
                    // stop - deliver
                    GiftManager.giftsUntilStop -= GiftManager.giftsToDeliver;
                    // santa.delivered + deliver
                    santaClaus.addTotalGiftsDelivered(GiftManager.giftsToDeliver);

                    System.out.println(Logger.log());
                    System.out.println("Premere invio per continuare");
                    scanner.nextLine();

                    GiftManager.resetGiftUntilStop();
                }
            }

            // 
        }

        System.out.println("PROGRAM FINISHED");
    }
}
