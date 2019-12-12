package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelectCompany extends AbstractWidget {

    private SelenideElement $bmw;

    public SelectCompany() {
        elements.put("bmw", $bmw);
    }
    @Override
    protected void init() {
        $bmw = $(By.xpath("//img[contains(text(), 'BMW')]"));
    }
}
