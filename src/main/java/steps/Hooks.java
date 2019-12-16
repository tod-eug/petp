package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;


public class Hooks {

    @After
    public void afterTest() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
