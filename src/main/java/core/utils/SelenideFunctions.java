package core.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.drivers.SelenideDriverStorage;
import org.openqa.selenium.By;

public class SelenideFunctions {

    public static SelenideElement s(String locator) {
        return SelenideDriverStorage.getDriver().$(locator);
    }

    public static SelenideElement s(By locator) {
        return SelenideDriverStorage.getDriver().$(locator);
    }

    public static ElementsCollection ss(String locator) {
        return SelenideDriverStorage.getDriver().$$(locator);
    }

    public static ElementsCollection ss(By locator) {
        return SelenideDriverStorage.getDriver().$$(locator);
    }
}
