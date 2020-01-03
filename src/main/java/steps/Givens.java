package steps;

import core.drivers.SelenideDriverStorage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static helpers.api.Offers.letCreateOffers;
import static helpers.db.Offers.letInsertOffers;

public class Givens {

    @Given("created list of offers")
    public void createOffers() {
        letCreateOffers();
    }

    @Given("site \"(.*)\" opened")
    public void openSite(String url) {
        SelenideDriverStorage.getDriver().hasWebDriverStarted();
        SelenideDriverStorage.getDriver().open(url);
    }

    @Given("in database inserted following offers:")
    public void insertValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            letInsertOffers(
                    stringMap.get("Company"),
                    stringMap.get("Model"),
                    stringMap.get("Color"),
                    Integer.parseInt(stringMap.get("Price")),
                    stringMap.get("Body type"));
        }
    }
}
