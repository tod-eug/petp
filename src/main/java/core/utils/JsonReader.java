package core.utils;

import kong.unirest.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Read json body from file
 */
public class JsonReader {

    public static String getJsonFromFile(String pathToFile) {
        StringBuilder content = new StringBuilder();
        try {
            final BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(pathToFile), StandardCharsets.UTF_8));
            String nextString;
            while ((nextString = br.readLine()) != null) {
                content.append(nextString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
