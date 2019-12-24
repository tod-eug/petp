package widgets.searchCar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Filter extends AbstractWidget {

    private SelenideElement $applyButton;
    private SelenideElement $bodyType;
    private ElementsCollection $bodyTypes;

    public Filter(String contextPath) {
        super(contextPath);
        elements.put("apply", $applyButton);
        elements.put("body type", $bodyType);
        lists.put("body types", $bodyTypes);
    }

    @Override
    protected void init() {
        $bodyType = $(By.xpath("//span[contains(text(), 'Кузов')]/../.."));
        $applyButton = $(By.cssSelector(".ButtonWithLoader__content"));
        $bodyTypes = $$(By.cssSelector(".MenuItem.MenuItem_size_m"));
    }
}