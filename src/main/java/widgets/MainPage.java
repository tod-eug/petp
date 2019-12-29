package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class MainPage extends AbstractWidget {
    private SelenideElement $addOffer;

    public MainPage() {
        elements.put("new offer", $addOffer);
    }

    @Override
    protected void init() {
        $addOffer = s(By.cssSelector(".HeaderAddOfferButton"));
    }
}
