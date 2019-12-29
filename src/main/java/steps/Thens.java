package steps;

import com.codeborne.selenide.Condition;
import core.widget.WidgetStorage;
import io.cucumber.java.en.Then;

import static core.utils.SelenideFunctions.s;

public class Thens {

    @Then("^text \"(.*)\" should be visible$")
    public void textShouldBeVisible(String text) {
        s("body").shouldHave(Condition.text(text));
    }

    @Then("^element \"(.*)\" should be visible in widget (.*)$")
    public void elementShouldBeVisibleInWidget(String element, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element, widget).scrollIntoView(false).shouldBe(Condition.visible);
    }

    @Then("^element \"(.*)\" should be visible$")
    public void elementShouldBeVisible(String element) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element).scrollIntoView(false).shouldBe(Condition.visible);
    }

    @Then("^element \"(.*)\" should have class \"(.*)\" in widget (.*)$")
    public void elementShouldBeInactiveInWidget(String element, String cssClass, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element, widget).scrollIntoView(false).shouldHave(Condition.cssClass(cssClass));
    }

    @Then("element \"(.*)\" should have class \"(.*)\"")
    public void elementShouldBeInactive(String element, String cssClass) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element).scrollIntoView(false).shouldHave(Condition.cssClass(cssClass));
    }


}
