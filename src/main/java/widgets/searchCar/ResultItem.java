package widgets.searchCar;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class ResultItem extends AbstractWidget {

    private SelenideElement $bodyType;

    public ResultItem(String contextPath, Integer widgetNumber) {
        super(contextPath, widgetNumber);
        elements.put("body type", $bodyType);
    }

    @Override
    protected void init() {
        contextDom = s(By.cssSelector(".ListingCars-module__list"));
        $bodyType = contextDom
                .$$(By.cssSelector(".ListingCars-module__listingItem")).get(getCurrentWidgetNumber())
                .$$(By.cssSelector(".ListingItemTechSummary-module__cell")).get(2);
    }
}