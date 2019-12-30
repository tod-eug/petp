package widgets.searchCar;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class SearchCar extends AbstractWidget {

    private SelenideElement $sort;

    public SearchCar(String contextPath) {
        super(contextPath);
        elements.put("sort", $sort);
    }
    @Override
    protected void init() {
        $sort = s(By.cssSelector(".ListingFilterPanel-module__sortFilter"));
    }
}