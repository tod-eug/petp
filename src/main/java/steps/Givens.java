package steps;

import io.cucumber.java.en.Given;

public class Givens {

    @Given("site \"(.*)\" opened")
    public void openSite(String url) {
        //open(url);
    }
}
