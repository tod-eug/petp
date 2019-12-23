package steps;

import com.codeborne.selenide.Condition;
import core.DataExchanger;
import core.widget.WidgetStorage;
import io.cucumber.java.en.When;

public class Whens {

    @When("^click on the (?:element|button|field|form|icon) \"(.*)\" in widget (.*)$")
    public void clickOnTheElement(String element, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).hover().click();
    }

    @When("^click on the (?:element|button|field|form|icon) \"(.*)\"$")
    public void clickOnTheElementWithoutContext(String element) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).hover().click();
    }

    @When("^fill (?:element|field|form) \"(.*)\" with value \"(.*)\" in widget (.*)$")
    public void fillElement(String element, String value, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).sendKeys(value);
    }

    @When("^fill (?:element|field|form) \"(.*)\" with value \"(.*)\"$")
    public void fillElementWithoutContext(String element, String value) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getElement(element).scrollIntoView(false).sendKeys(value);
    }

    @When("^choose value \"(.*)\" from list \"(.*)\" in widget (.*)$")
    public void chooseElementFromList(String value, String list, String widget) {
        DataExchanger.saveValue("CONTEXT", widget);
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getList(list).find(Condition.text(value)).waitUntil(Condition.visible, 10000).click();
    }

    @When("^choose value \"(.*)\" from list \"(.*)\"$")
    public void chooseElementFromListWithoutContext(String value, String list) {
        WidgetStorage widgetStorage = new WidgetStorage(DataExchanger.getValue("CONTEXT"));
        widgetStorage.getList(list).find(Condition.text(value)).waitUntil(Condition.visible, 10000).click();
    }
}