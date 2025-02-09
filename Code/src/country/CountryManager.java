package country;

import util.TimezoneManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryManager {
    private ArrayList<Country> countryArrayList;
    private HashMap<String, ArrayList<Country>> countryGroupByTimeZone;

    public CountryManager(ArrayList<Country> countryArrayList) {
        this.countryArrayList = countryArrayList;
        divideByTimeZone();
    }

    private void divideByTimeZone() {
        countryGroupByTimeZone = new HashMap<>();

        for (int i = -12; i < 15; i++) {
            String timeZone = TimezoneManager.getTimezoneString(i);

            List<Country> countriesWithTimeZone = countryArrayList.stream().filter(country -> country.getTimeZone().equals(timeZone)).toList();

            countryGroupByTimeZone.put(timeZone, new ArrayList<>(countriesWithTimeZone));
        }
    }

    public ArrayList<Country> getCountriesInTimezone(String timezone) {
        ArrayList<Country> c = countryGroupByTimeZone.get(timezone);

        return c == null ? new ArrayList<>() : c;
    }
}
