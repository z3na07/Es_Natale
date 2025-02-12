import country.Country;
import country.CountryManager;
import reindeer.ReindeerTeam;
import util.*;

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
        GiftManager giftManager = new GiftManager(250_000_000);
        TimezoneManager timezoneManager = new TimezoneManager(3);
        Logger.setReindeerTeam(reindeerTeam);
        Logger.setTimezoneManager(timezoneManager);

        Scanner scanner = new Scanner(System.in);

        for (int i = -12; i < 15; i++) {
            // Set the current timezone
            timezoneManager.setCurrentTimezone(i);

            // Check how many timezone santa passed
            if (timezoneManager.isTimeToChange()) {
                Util.stopProcess(scanner, santaClaus, giftManager, false);
            }

            // Get all the country in this timezone
            ArrayList<Country> countriesInTimezone = countryManager.getCountriesInTimezone(timezoneManager.getCurrentTimezoneString());

            // if there are no countries in timezone break
            if (countriesInTimezone.isEmpty()) {
                break;
            }

            // Get how many gifts santa have to deliver in the specific timezone
            for (Country country : countriesInTimezone) {
                giftManager.incrementGiftToDeliver(country.getPopulationOfGoodChilder());
            }

            // If the gift to deliver are less than gift until stop
            if (giftManager.getGiftsToDeliver() <= giftManager.getGiftsUntilStop()) {
                santaClaus.addTotalGiftsDelivered(giftManager.getGiftsToDeliver());
                giftManager.decrementGiftUntilStop(giftManager.getGiftsToDeliver());
            } else {
                // cycle until deliver > stop
                while (giftManager.getGiftsToDeliver() > giftManager.getGiftsUntilStop()) {
                    // deliver - stop
                    giftManager.decrementGiftToDeliver(giftManager.getGiftsUntilStop());
                    // santa.delivered + stop
                    santaClaus.addTotalGiftsDelivered(giftManager.getGiftsUntilStop());

                    // Stop process
                    Util.stopProcess(scanner, santaClaus, giftManager, true);
                }

                // Check if there are gift left
                if (giftManager.getGiftsToDeliver() > 0 && giftManager.getGiftsToDeliver() < giftManager.getMaxGift()) {
                    // stop - deliver
                    giftManager.decrementGiftUntilStop(giftManager.getGiftsToDeliver());
                    // santa.delivered + deliver
                    santaClaus.addTotalGiftsDelivered(giftManager.getGiftsToDeliver());
                }
            }

            timezoneManager.incrementTimezonePassed();
        }

        System.out.println("PROGRAM FINISHED");
    }
}
