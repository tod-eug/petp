package core.drivers;

import com.codeborne.selenide.SelenideDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.currentThread;

/**
 * Map driverMap contains all webDrivers. You can get driver by running command
 * <code>SelenideDriverStorage.getDriver()</code>. After end of test driver will be killed
 * by Driver killer.
 *
 * For example your test can be written as follows:
 *
 * Given some preconditions
 * And some other preconditions
 * When we create new webDriver
 * And open some web page
 * And do something
 * Then something will be...
 */
public class SelenideDriverStorage {

    private static Map<Long, SelenideDriver> driverMap = new ConcurrentHashMap<>();

    /**
     * Create new webDriver and start Driver killer for this driver
     * @return new webDriver
     */
    public static SelenideDriver getDriver() {
        SelenideDriver driver;
        if (driverMap.containsKey(currentThread().getId())) {
            driver = driverMap.get(currentThread().getId());
        } else {
            driver = new SelenideDriver(new CustomConfig());
            driverMap.put(currentThread().getId(), driver);
            new DriverKiller(currentThread().getId()).start();
        }
        return driver;
    }

    /**
     * Close webDriver by threadId
     * @param id threadId
     */
    public static void closeDriver(Long id) {
        driverMap.get(id).close();
    }
}
