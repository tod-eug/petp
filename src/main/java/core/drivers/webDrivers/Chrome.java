package core.drivers.webDrivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static core.drivers.options.CustomChromeOptions.getChromeOptions;

public class Chrome implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        return new ChromeDriver(getChromeOptions().merge(desiredCapabilities));
    }
}
