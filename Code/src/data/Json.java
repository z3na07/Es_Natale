import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {

    /**
     * This class read json arrays and json object from a file.
     */
    static class Reader {
        
        /**
         * Reads a JSON file from the specified path and returns a JSONObject.
         *
         * @param path the path of the JSON file to read.
         * @return a JSONObject containing the data from the JSON file.
         * @throws IOException if an error occurs while reading the file.
         * @throws ParseException if the file is not in a valid JSON format.
         */
        public static JSONObject object(String path, JSONObject obj) throws IOException, ParseException {
            JSONParser parser = new JSONParser();

            try (FileReader reader = new FileReader(path)) {
                // Parse the JSON file and return it as a JSONObject
                return (JSONObject) parser.parse(reader);
            }
        }

        /**
         * Reads a JSON file from the specified path and returns a JSONArray.
         *
         * @param path the path of the JSON file to read.
         * @return a JSONArray containing the data from the JSON file.
         * @throws IOException if an error occurs while reading the file.
         * @throws ParseException if the file is not in a valid JSON format.
         */
        public static JSONArray array(String path, JSONArray array) throws IOException, ParseException {
            JSONParser parser = new JSONParser();

            try (FileReader reader = new FileReader(path)) {
                // Parse the JSON file and return it as a JSONArray
                return (JSONArray) parser.parse(reader);
            }
        }
    }

    /**
     * This class write json objects json arrays in file.
     */
    static class Writer {
        /**
         * Writes a JSON object to the specified file.
         *
         * @param obj  the JSON object to write.
         * @param path the path of the file where the JSON object will be written.
         * @throws RuntimeException if an error occurs while writing to the file.
         */
        public static void object(String path, JSONObject obj) {
            try (FileWriter file = new FileWriter(path)) {
                file.write(obj.toJSONString()); // Convert the JSON object to a string and write it to the file
                file.flush(); // Ensure all data is written
            } catch (IOException e) {
                throw new RuntimeException("An error occurred while writing the JSON object to the file: " + path, e);
            }
        }

        /**
         * Writes a JSON array to the specified file.
         *
         * @param arr  the JSON array to write.
         * @param path the path of the file where the JSON array will be written.
         * @throws RuntimeException if an error occurs while writing to the file.
         */
        public static void array(String path, JSONArray arr) {
            try (FileWriter file = new FileWriter(path)) {
                file.write(arr.toJSONString()); // Convert the JSON array to a string and write it to the file
                file.flush(); // Ensure all data is written
            } catch (IOException e) {
                throw new RuntimeException("An error occurred while writing the JSON array to the file: " + path, e);
            }
        }
    }
}
