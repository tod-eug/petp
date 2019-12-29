package core.drivers;

import com.codeborne.selenide.impl.StaticConfig;

public class CustomConfig extends StaticConfig {

    private String browser;

    public String browser() {
        browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "chrome": return "core.drivers.webDrivers.Chrome";
            case "firefox": return "core.drivers.webDrivers.Firefox";
            default: return "drivers.webDrivers.Chrome";
        }
    }
}
