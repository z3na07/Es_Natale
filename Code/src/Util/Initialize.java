package Util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import country.Country;
import data.Json;

import java.util.ArrayList;

public class Initialize {
    private ArrayList<Country> countryArrayList;

    public Initialize(String countryArrayListPath) {
        this.countryArrayList = loadCountry(countryArrayListPath);
    }

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
}
