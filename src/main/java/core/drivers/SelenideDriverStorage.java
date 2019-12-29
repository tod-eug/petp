package core.drivers;

import com.codeborne.selenide.SelenideDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.currentThread;

public class SelenideDriverStorage {

    private static Map<Long, SelenideDriver> driverMap = new ConcurrentHashMap<>();

    public static SelenideDriver getDriver() {
        SelenideDriver driver;
        if (driverMap.containsKey(currentThread().getId())) {
            driver = driverMap.get(currentThread().getId());
        } else {
            driver = new SelenideDriver(new CustomConfig());
            driverMap.put(currentThread().getId(), driver);
        }
        return driver;
    }
}
