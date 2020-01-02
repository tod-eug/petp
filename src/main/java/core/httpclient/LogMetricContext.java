package core.httpclient;

import kong.unirest.HttpResponseSummary;
import kong.unirest.MetricContext;

public class LogMetricContext implements MetricContext {
    @Override
    public void complete(HttpResponseSummary httpResponse, Exception ex) {
        HttpClientLogStorage.addLogInformation("RESPONSE STATUS: " + httpResponse.getStatus());
        HttpClientLogStorage.addLogInformation("RESPONSE TEXT: " + httpResponse.getStatusText());
        if (ex != null) {
            HttpClientLogStorage.addLogInformation("EXCEPTION: " + ex.getMessage());
        }
        HttpClientLogStorage.addLogInformation("--------------End Request--------------");
    }
}
