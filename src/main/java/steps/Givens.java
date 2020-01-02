package steps;

import core.drivers.SelenideDriverStorage;
import io.cucumber.java.en.Given;

import static helpers.api.Offers.letCreateOffers;

public class Givens {

    @Given("create list of offers")
    public void createOffers() {
        letCreateOffers();
    }

    @Given("site \"(.*)\" opened")
    public void openSite(String url) {
        SelenideDriverStorage.getDriver().hasWebDriverStarted();
        SelenideDriverStorage.getDriver().open(url);
    }
}
