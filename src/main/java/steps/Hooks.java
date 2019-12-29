package steps;

import com.codeborne.selenide.SelenideDriver;
import core.drivers.SelenideDriverStorage;
import io.cucumber.java.After;


public class Hooks {

    @After
    public void afterTest() {
        SelenideDriver driver = SelenideDriverStorage.getDriver();
        driver.clearCookies();
    }
}
