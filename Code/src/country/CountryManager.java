package country;

import util.TimezoneManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class store all counties and divide them by timezone.
 */
public class CountryManager {
    private ArrayList<Country> countryArrayList;
    private HashMap<String, ArrayList<Country>> countryGroupByTimeZone;

    /**
     * On initialization the CountryManager obj take the list of countries and
     * divide them in timezone
     * 
     * @param countryArrayList ArrayList of all the countries
     */
    public CountryManager(ArrayList<Country> countryArrayList) {
        this.countryArrayList = countryArrayList;
        divideByTimeZone();
    }

    /**
     * Divide the countries ArrayList by timezone
     */
    private void divideByTimeZone() {
        countryGroupByTimeZone = new HashMap<>();

        for (int i = -12; i < 15; i++) {
            String timeZone = TimezoneManager.getTimezoneString(i);

            List<Country> countriesWithTimeZone = countryArrayList.stream().filter(country -> country.getTimeZone().equals(timeZone)).toList();

            countryGroupByTimeZone.put(timeZone, new ArrayList<>(countriesWithTimeZone));
        }
    }

    /**
     * Get all the countries in a specific timezone passed as paramenter
     * 
     * @param timezone String of the timezone (es: UTC-03:00)
     * @return an empty arraylist if there are no countries in timezone 
     *         else return an arraylist of all the coutries in that timezone
     */
    public ArrayList<Country> getCountriesInTimezone(String timezone) {
        ArrayList<Country> c = countryGroupByTimeZone.get(timezone);

        return c == null ? new ArrayList<>() : c;
    }
}
