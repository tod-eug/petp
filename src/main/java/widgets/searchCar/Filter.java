package widgets.searchCar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Filter extends AbstractWidget {

    private SelenideElement $applyButton;
    private ElementsCollection $bodyTypes;
    private ElementsCollection $companies;

    public Filter(String contextPath) {
        super(contextPath);
        elements.put("apply", $applyButton);
        lists.put("body types", $bodyTypes);
        lists.put("companies", $companies);
    }

    @Override
    protected void init() {
        $applyButton = $(By.cssSelector(".ButtonWithLoader__content"));
        $bodyTypes = $$(By.cssSelector(".MenuItem.MenuItem_size_m"));
        $companies = $$(By.cssSelector(".MenuItem.MenuItem_size_m"));
    }
}