package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelectYear extends AbstractWidget {

    private SelenideElement $2017;

    public SelectYear() {
        elements.put("2017", $2017);
    }
    @Override
    protected void init() {
        $2017 = $(By.xpath("//span[contains(text(), '2017')]"));
    }
}
