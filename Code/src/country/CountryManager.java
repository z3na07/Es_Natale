package country;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryManager {
    private ArrayList<Country> countryArrayList;
    private HashMap<String, ArrayList<Country>> countryGroupByTimeZone;

    public CountryManager(ArrayList<Country> countryArrayList, HashMap<String, ArrayList<Country>> countryGroupByTimeZone) {
        this.countryArrayList = countryArrayList;
        this.countryGroupByTimeZone = countryGroupByTimeZone;
    }
}
