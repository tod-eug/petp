package core;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

public abstract class AbstractWidget {

    private HashMap<String, SelenideElement> elements = new HashMap<>();
    private HashMap<String, ElementsCollection> lists = new HashMap<>();

    public void setElement(String element) {

    }

}
