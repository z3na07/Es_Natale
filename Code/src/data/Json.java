package data;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Json class provides methods to read and write JSON files using Google's Gson library.
 * It is structured into two nested classes: `Reader` for reading JSON data and `Writer` for writing JSON data.
 */
public class Json {

    /**
     * The `Reader` class provides methods for reading JSON data from files.
     */
    static class Reader {

        /**
         * Attempts to open a file at the specified path and return a FileReader object.
         *
         * @param path The path to the file to be read.
         * @return A FileReader object for the specified file, or null if the file cannot be opened.
         */
        private static FileReader readFile(String path) {
            try (FileReader reader = new FileReader(path)) {
                return reader;
            } catch (IOException e) {
                return null;
            }
        }

        /**
         * Reads a JSON file and parses it into a generic object of the specified type.
         *
         * @param <T>   The type of the object to be created from the JSON data.
         * @param path  The path to the JSON file to be read.
         * @param clazz The class of the object to be created from the JSON data.
         * @return An object of the specified type representing the JSON content, or null if the file cannot be read.
         */
        public static <T> T read(String path, Class<T> clazz) {
            FileReader reader = readFile(path);

            if (reader == null) {
                return null; // If the file cannot be opened, return null
            }

            // Parse the JSON file into a JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);

            // Cast and return the JsonElement as the specified type
            return (T) jsonElement;
        }
    }

    /**
     * The `Writer` class provides methods for writing JSON data to files.
     */
    static class Writer {
        /**
         * Writes a string to a file at the specified path.
         *
         * @param path The path to the file where the string will be written.
         * @param s    The string content to write to the file.
         * @throws RuntimeException If an error occurs during the file write operation.
         */
        private static void writeFile(String path, String s) {
            try (FileWriter file = new FileWriter(path)) {
                file.write(s);
                file.flush();
            } catch (IOException e) {
                throw new RuntimeException("An error occurred while writing the JSON object to the file: " + path, e);
            }
        }

        /**
         * Converts a JsonElement to a string and writes it to a file at the specified path.
         *
         * @param path        The path to the file where the JSON data will be written.
         * @param jsonElement The JsonElement object to be written to the file.
         * @throws RuntimeException If an error occurs during the file write operation.
         */
        public static void write(String path, JsonElement jsonElement) {
            writeFile(path, jsonElement.toString());
        }
    }
}
