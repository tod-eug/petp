package steps;

import com.codeborne.selenide.SelenideDriver;
import core.config.Configuration;
import core.drivers.SelenideDriverStorage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void beforeTest() {
        Configuration.setUp();
    }

    @After
    public void afterTest() {
        SelenideDriver driver = SelenideDriverStorage.getDriver();
        driver.clearCookies();
    }
}
