package core.httpclient;

import kong.unirest.HttpRequestSummary;
import kong.unirest.MetricContext;
import kong.unirest.UniMetric;

public class LogMetric implements UniMetric {


    @Override
    public MetricContext begin(HttpRequestSummary request) {
        HttpClientLogStorage.addLogInformation("--------------Begin Request--------------");
        HttpClientLogStorage.addLogInformation("Method: " + request.getHttpMethod());
        HttpClientLogStorage.addLogInformation("PATH: " + request.getRawPath());
        return new LogMetricContext();
    }
}
