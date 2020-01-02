package core.httpclient;

import kong.unirest.Unirest;
import kong.unirest.UnirestInstance;

public class HttpClientFactory {


    public static UnirestInstance createHttpClient() {
        UnirestInstance httpClient = Unirest.spawnInstance();
        httpClient.config()
                .verifySsl(false)
                .instrumentWith(new LogMetric())
                .followRedirects(true);
        return httpClient;
    }
}
