package widgets.searchCar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;
import static core.utils.SelenideFunctions.ss;

public class Filter extends AbstractWidget {

    private SelenideElement $bodyType;
    private SelenideElement $company;
    private SelenideElement $price;
    private SelenideElement $applyButton;
    private ElementsCollection $optionsList;

    public Filter(String contextPath) {
        super(contextPath);
        elements.put("apply", $applyButton);
        elements.put("body type", $bodyType);
        elements.put("company", $company);
        elements.put("price", $price);
        lists.put("options list", $optionsList);
    }

    @Override
    protected void init() {
        $bodyType = ss(By.cssSelector(".ListingCarsFilters-module__row")).get(1).$(By.cssSelector(".Select__button"));
        $company = s(By.cssSelector(".MMMFilter-module__MMMFilter__item"));
        $applyButton = s(By.cssSelector(".ButtonWithLoader__content"));
        $price = s(By.name("price_from"));
        $optionsList = ss(By.cssSelector(".MenuItem.MenuItem_size_m"));
    }
}