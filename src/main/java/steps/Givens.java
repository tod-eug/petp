package steps;

import core.drivers.SelenideDriverStorage;
import io.cucumber.java.en.Given;

public class Givens {

    @Given("site \"(.*)\" opened")
    public void openSite(String url) {
        SelenideDriverStorage.getDriver().hasWebDriverStarted();
        SelenideDriverStorage.getDriver().open(url);
    }
}
