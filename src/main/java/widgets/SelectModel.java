package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class SelectModel extends AbstractWidget {

    private SelenideElement $company;
    private SelenideElement $m5;

    public SelectModel() {
        elements.put("company name", $company);
        elements.put("m5", $m5);
    }
    @Override
    protected void init() {
        $company = s(By.cssSelector(".mmm-line-item.mmm-line-item_visible.i-bem"));
        $m5 = s(By.xpath("//div[contains(text(), 'M5')]"));
    }
}
