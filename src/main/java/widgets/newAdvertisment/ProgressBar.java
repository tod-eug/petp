package widgets.newAdvertisment;

import com.codeborne.selenide.SelenideElement;
import core.widget.AbstractWidget;
import org.openqa.selenium.By;

import static core.utils.SelenideFunctions.s;

public class ProgressBar extends AbstractWidget {

    private SelenideElement $companyAndModel;
    private SelenideElement $colorAndRun;

    public ProgressBar(String contextPath) {
        super(contextPath);
        elements.put("company and model", $companyAndModel);
        elements.put("color and run", $colorAndRun);
    }
    @Override
    protected void init() {
        $companyAndModel = s(By.cssSelector(".progress-bar__mmm"));
        $colorAndRun = s(By.cssSelector(".progress-bar__color_run"));
    }
}
