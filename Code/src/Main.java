import country.Country;
import country.CountryManager;
import reindeer.ReindeerTeam;
import util.GiftManager;
import util.Initialize;
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
        Logger.setReindeerTeam(reindeerTeam);

        Scanner scanner = new Scanner(System.in);

        for (int i = -12; i < 15; i++) {
        
            /*
            TODO Check if the time zone just passed, it is the third time zone passed
                util.TimezoneManager.timezonePassed > util.TimezoneManager.maxTimezone
            */

            String timezone = CountryManager.getTimezoneString(i);

            ArrayList<Country> countriesInTimezone = countryManager.getCountriesInTimezone(timezone);

            // if there are no countries in timezone break
            if (countriesInTimezone.isEmpty()) {
                break;
            }

            // Get how many gifts santa have to deliver in the specific timezone
            for (Country c : countriesInTimezone) {
                GiftManager.incrementGiftToDeliver(c.getPopulationOfGoodChilder());
            }

            if (GiftManager.getGiftsToDeliver() <= GiftManager.getGiftsUntilStop()) {
                santaClaus.addTotalGiftsDelivered(GiftManager.getGiftsToDeliver());
                GiftManager.decrementGiftUntilStop(GiftManager.getGiftsToDeliver());
            } else {
                // cycle until it's done
                while (GiftManager.getGiftsToDeliver() > GiftManager.getGiftsUntilStop()) {
                    // deliver - stop
                    GiftManager.decrementGiftToDeliver(GiftManager.getGiftsUntilStop());
                    // santa.delivered + stop
                    santaClaus.addTotalGiftsDelivered(GiftManager.getGiftsUntilStop());

                    // Ask to continue
                    System.out.println(Logger.log());
                    System.out.println("Premere invio per continuare");
                    scanner.nextLine();
                }

                // Check if there are gift left
                if (GiftManager.getGiftsToDeliver() > 0 && GiftManager.getGiftsToDeliver() < GiftManager.getMaxGift()) {
                    // stop - deliver
                    GiftManager.decrementGiftUntilStop(GiftManager.getGiftsToDeliver());
                    // santa.delivered + deliver
                    santaClaus.addTotalGiftsDelivered(GiftManager.getGiftsToDeliver());

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
