package widgets;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProgressBar extends AbstractWidget {

    private SelenideElement $companyAndModel;
    private SelenideElement $colorAndRun;

    public ProgressBar() {
        elements.put("company and model", $companyAndModel);
        elements.put("color and run", $colorAndRun);
    }
    @Override
    protected void init() {
        $companyAndModel = $(By.cssSelector(".progress-bar__mmm"));
        $colorAndRun = $(By.cssSelector(".progress-bar__color_run"));
    }
}
