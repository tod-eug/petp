package steps;

import com.codeborne.selenide.Condition;
import core.DataExchanger;
import core.widget.WidgetStorage;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$;

public class Thens {

    @Then("^text \"(.*)\" should be visible$")
    public void textShouldBeVisible(String text) {
        $("body").shouldHave(Condition.text(text));
    }

    @Then("^(?:element|button|field|form|icon) \"(.*)\" should be visible in widget (.*)$")
    public void elementShouldBeVisible(String element, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldBe(Condition.visible);
    }

    @Then("^(?:element|button|field|form|icon) \"(.*)\" should be visible$")
    public void elementShouldBeVisibleWithoutContext(String element) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldBe(Condition.visible);
    }

    @Then("^(?:element|button|field|form|icon) \"(.*)\" should have class \"(.*)\" in widget (.*)$")
    public void elementShouldHaveClass(String element, String cssClass, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldHave(Condition.cssClass(cssClass));
    }

    @Then("^(?:element|button|field|form|icon) \"(.*)\" should have class \"(.*)\"$")
    public void elementShouldHaveClassWithoutContext(String element, String cssClass) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldHave(Condition.cssClass(cssClass));
    }

    @Then("^(?:element|button|field|form) \"(.*)\" should have text \"(.*)\" in widget (.*)$")
    public void elementShouldHaveText(String element, String text, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldHave(Condition.text(text));
    }

    @Then("^(?:element|button|field|form) \"(.*)\" should have text \"(.*)\"$")
    public void elementShouldHaveTextWithoutContext(String element, String text) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).shouldHave(Condition.text(text));
    }

}