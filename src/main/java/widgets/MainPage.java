package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.ss;
import static core.utils.SelenideFunctions.s;

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
        $addOffer = s(By.cssSelector(".HeaderAddOfferButton"));
        $car = ss(By.cssSelector(".HeaderMenuTitleLink")).findBy(Condition.text("Легковые"));
        $addOffer = s(By.cssSelector(".HeaderAddOfferButton"));
    }
}
