package core.drivers.options;

import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomFirefoxOptions {

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(false);
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }
}
