package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends AbstractWidget {
    private SelenideElement $addOffer;
    private SelenideElement $car;

    public MainPage(String contextPath) {
        super(contextPath);
        elements.put("new offer", $addOffer);
        elements.put("car", $car);
    }

    @Override
    protected void init() {
        $addOffer = $(By.cssSelector(".HeaderAddOfferButton"));
        $car = $$(By.cssSelector(".HeaderMenuTitleLink")).findBy(Condition.text("Легковые"));
    }
}
