package widgets.searchCar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;
import static core.utils.SelenideFunctions.ss;

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
        $bodyType = s(By.xpath("//span[contains(text(), 'Кузов')]/../.."));
        $applyButton = s(By.cssSelector(".ButtonWithLoader__content"));
        $bodyTypes = ss(By.cssSelector(".MenuItem.MenuItem_size_m"));
    }
}