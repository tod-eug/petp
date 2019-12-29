package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class AddAdvertisement extends AbstractWidget {

    private SelenideElement $blueColor;
    private SelenideElement $run;

    public AddAdvertisement() {
        elements.put("blue", $blueColor);
        elements.put("run", $run);
    }

    @Override
    protected void init() {
        $blueColor = s(By.xpath("//span[@style='background-color: #0433FF']"));
        $run = s(By.xpath("//input[@name='run']"));
    }
}
