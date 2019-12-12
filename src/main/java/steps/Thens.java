package steps;

import com.codeborne.selenide.Condition;
import core.widget.WidgetStorage;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$;

public class Thens {

    @Then("^text \"(.*)\" should be visible$")
    public void textShouldBeVisible(String text) {
        $("body").shouldHave(Condition.text(text));
    }

    @Then("^element \"(.*)\" should be visible in widget (.*)$")
    public void elementShouldBeVisibleInWidget(String element, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element, widget).scrollIntoView(false).shouldBe(Condition.visible);
    }

    @Then("^element \"(.*)\" should be visible$")
    public void elementShouldBeVisible(String element, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element).scrollIntoView(false).shouldBe(Condition.visible);
    }
}
