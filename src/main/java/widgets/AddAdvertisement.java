package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAdvertisement extends AbstractWidget {

    private SelenideElement $blueColor;
    private SelenideElement $run;

    public AddAdvertisement() {
        elements.put("blue", $blueColor);
        elements.put("run", $run);
    }

    @Override
    protected void init() {
        $blueColor = $(By.xpath("//span[@style='background-color: #0433FF']"));
        $run = $(By.xpath("//input[@name='run']"));
    }
}
