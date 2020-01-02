package core.httpclient;

public class HttpClientLogStorage {
    private static ThreadLocal<String> log = new ThreadLocal<String>();

    public static void addLogInformation(String info) {
        log.set(info);
    }

    public String getLogInformation() {
        return log.get();
    }
}
