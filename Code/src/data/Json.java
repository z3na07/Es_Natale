package data;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static class Reader {
        /**
         * Reads a JSON file and converts its content into the specified class type using Gson.
         *
         * @param path  the file path of the JSON file.
         * @param clazz the class type to convert the JSON into.
         * @param <T>   the type of the resulting object.
         * @return the deserialized object of type T, or null if an error occurs.
         */
        public static <T> T read(String path, Class<T> clazz) {
            try (FileReader reader = new FileReader(path)) { // Ensure the FileReader is closed after use.
                JsonElement jsonElement = JsonParser.parseReader(reader); // Parse the JSON file.
                return gson.fromJson(jsonElement, clazz); // Deserialize the JSON into the specified type.
            } catch (IOException e) {
                throw new RuntimeException("Error reading JSON file: " + path, e);
            }
        }
    }

    public static class Writer {
        /**
         * Writes a string to the specified file path.
         *
         * @param path the file path to write to.
         * @param s    the string to be written to the file.
         * @throws RuntimeException if an error occurs during writing.
         */
        private static void writeFile(String path, String s) {
            try (FileWriter file = new FileWriter(path)) { // Ensure the FileWriter is closed after use.
                file.write(s); // Write the string to the file.
                file.flush(); // Flush the data to ensure it is saved.
            } catch (IOException e) {
                throw new RuntimeException("An error occurred while writing to the file: " + path, e);
            }
        }

        /**
         * Writes a JSON element to the specified file path.
         *
         * @param path        the file path to write to.
         * @param jsonElement the JSON element to be written to the file.
         * @throws RuntimeException if an error occurs during writing.
         */
        public static void write(String path, JsonElement jsonElement) {
            writeFile(path, jsonElement.toString()); // Convert the JSON element to a string and write it to the file.
        }
    }
}
