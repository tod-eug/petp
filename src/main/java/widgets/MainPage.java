package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbstractWidget {
    private SelenideElement $addOffer;

    MainPage() {
        elements.put("new offer", $addOffer);
    }

    @Override
    protected void init() {
        $addOffer = $(By.cssSelector(".HeaderAddOfferButton"));
    }
}
