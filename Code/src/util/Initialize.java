package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import country.Country;
import data.Json;
import reindeer.Reindeer;

import java.util.ArrayList;

/**
 * This class deals with get the data from file at the start at the program
 */
public class Initialize {
    private ArrayList<Country> countryArrayList;
    private ArrayList<Reindeer> reindeerArrayList;

    /**
     * when instantiated the obj load the list of countries and the list of reideer
     */
    public Initialize(String countryArrayListPath, String reindeerPath) {
        this.countryArrayList = loadCountry(countryArrayListPath);
        this.reindeerArrayList = loadReindeer(reindeerPath);
    }

    /**
     * This method get the reindeer list and assign it to {@code reindeerArrayList}
     * 
     * @param reindeerPath path of the file where is save the list of reindeer
     */
    private ArrayList<Reindeer> loadReindeer(String reindeerPath) {
        ArrayList<Reindeer> reindeer = new ArrayList<>();

        JsonArray jsonReindeer = Json.Reader.read(reindeerPath, JsonArray.class);

        for (JsonElement jsonElement : jsonReindeer) {
            reindeer.add(new Reindeer(
                    jsonElement.toString().substring(1, jsonElement.toString().length() - 1),
                    false
            ));
        }

        return reindeer;
    }

    /**
     * This method get the country list and assign it to {@code countryArrayList}
     * 
     * @param reindeerPath path of the file where is save the list of countries
     */
    private ArrayList<Country> loadCountry(String countryArrayListPath) {
        ArrayList<Country> countries = new ArrayList<>();

        String timezone = "", name = "";
        long population = 0;
        double goodChildrenPercentage = 0F;

        JsonArray jsonCountryArray = Json.Reader.read(countryArrayListPath, JsonArray.class);

        // Cycle through every timezone obj
        for (JsonElement jsonElement : jsonCountryArray) {
            JsonObject jsonObject = (JsonObject) jsonElement;

            // Get the timezone
            timezone = jsonObject.get("timezone").getAsString(); // This get the string of the timezone es: "UTC+14"

            // Get the json array of countries
            JsonArray countriesJson = jsonObject.get("countries").getAsJsonArray();

            // Cycle through every country
            for (JsonElement jsonElementCountries : countriesJson) {
                JsonObject jsonObject1 = jsonElementCountries.getAsJsonObject();

                // Get the country attribute
                name = jsonObject1.get("name").getAsString();
                population = jsonObject1.get("population").getAsLong();
                goodChildrenPercentage = jsonObject1.get("good_children_percentage").getAsDouble();

                // Create and add the new country
                countries.add(new Country(
                        name,
                        population,
                        goodChildrenPercentage,
                        timezone
                ));
            }
        }

        return countries;
    }

    public ArrayList<Country> getCountryArrayList() {
        return countryArrayList;
    }

    public ArrayList<Reindeer> getReindeerArrayList() {
        return reindeerArrayList;
    }
}
