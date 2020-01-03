package helpers.api;

import core.config.Configuration;
import core.exceptions.HttpClientException;
import core.httpclient.HttpClientFactory;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestInstance;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import static core.utils.JsonReader.getJsonFromFile;

/**
 * This class may be used for creating some preconditions before test using Rest api.
 * Test data for creating preconditions may be taken from file(s)
 * (files can be storage for example in main/resources/json) or may be created in class manually.
 */
public class Offers {

    public static void letCreateOffers() {

        UnirestInstance httpClient = HttpClientFactory.createHttpClient();
        HttpResponse<JsonNode> response = httpClient.get(Configuration.configurationProperties.get("API_PATH")).asJson();

        if (!response.isSuccess()) {
            throw new HttpClientException("Error status: " + response.getStatus() + "\nError text: " + response.getStatusText());
        }
        httpClient.shutDown();
    }

    /**
     * Creating preconditions using Rest api from file
     */
    public static void letCreateOffersFromFile() {

        UnirestInstance httpClient = HttpClientFactory.createHttpClient();
        HttpResponse<JsonNode> response = httpClient.post(Configuration.configurationProperties.get("API_PATH")).body(getJsonFromFile("src/main/resources/json/offers.json")).asJson();

        if (!response.isSuccess()) {
            throw new HttpClientException("Error status: " + response.getStatus() + "\nError text: " + response.getStatusText());
        }
        httpClient.shutDown();
    }

    /**
     * Creating preconditions using Rest api manually through creating JsonObject
     */
    public static void letCreateOffersManually() {
        UnirestInstance httpClient = HttpClientFactory.createHttpClient();

        JSONObject car1 = new JSONObject();
        car1.put("company", "BMW");
        car1.put("model", "m5");
        car1.put("color", "blue");
        car1.put("price", 10000);

        JSONObject car2 = new JSONObject();
        car2.put("company", "Audi");
        car2.put("model", "A4");
        car2.put("color", "black");
        car2.put("price", 8000);

        JSONObject car3 = new JSONObject();
        car3.put("company", "Mercedes-benz");
        car3.put("model", "C200");
        car3.put("color", "white");
        car3.put("price", 12000);

        JSONArray json = new JSONArray();
        json.put(car1);
        json.put(car2);
        json.put(car3);

        HttpResponse<JsonNode> response = httpClient.post(Configuration.configurationProperties.get("API_PATH")).body(json.toString()).asJson();

        if (!response.isSuccess()) {
            throw new HttpClientException("Error status: " + response.getStatus() + "\nError text: " + response.getStatusText());
        }
        httpClient.shutDown();
    }
}
