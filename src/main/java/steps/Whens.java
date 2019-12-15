package steps;

import core.widget.WidgetStorage;
import io.cucumber.java.en.When;

public class Whens {

    @When("^click on the element \"(.*)\" in widget (.*)$")
    public void clickOnTheElementInWidget(String element, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        //widgetStorage.setContext(widget);
        widgetStorage.getElement(element, widget).scrollIntoView(false).hover().click();
    }

    @When("^click on the element \"(.*)\"$")
    public void clickOnTheElement(String element) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element).scrollIntoView(false).hover().click();
    }

    @When("^fill element \"(.*)\" with value \"(.*)\" in widget (.*)$")
    public void fillElementInWidget(String element, String value, String widget) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element, widget).scrollIntoView(false).sendKeys(value);
    }

    @When("^fill element \"(.*)\" with value \"(.*)\"$")
    public void fillElement(String element, String value) {
        WidgetStorage widgetStorage = new WidgetStorage();
        widgetStorage.getElement(element).scrollIntoView(false).sendKeys(value);
    }

}
