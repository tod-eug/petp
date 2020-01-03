package core.drivers;

import com.codeborne.selenide.impl.StaticConfig;
import core.config.Browsers;
import core.config.Configuration;

public class CustomConfig extends StaticConfig {

    private Browsers browser;

    public String browser() {
        browser = Configuration.browser;

        switch (browser) {
            case CHROME: return "core.drivers.webDrivers.Chrome";
            case FIREFOX: return "core.drivers.webDrivers.Firefox";
            default: return "drivers.webDrivers.Chrome";
        }
    }
}
