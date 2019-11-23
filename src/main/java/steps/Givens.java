package steps;

import io.cucumber.java.en.Given;
import static com.codeborne.selenide.Selenide.open;

public class Givens {

    @Given("site \"(.*)\" opened")
    public void openSite(String url) {
        open(url);
    }
}
