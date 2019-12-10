package core.widget;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.exceptions.ArgumentNotFoundException;

import java.util.HashMap;

public abstract class AbstractWidget {

    protected HashMap<String, AbstractWidget> widgets = new HashMap<>();
    protected HashMap<String, SelenideElement> elements = new HashMap<>();
    protected HashMap<String, ElementsCollection> lists = new HashMap<>();

    public static String currentWidget;

    public AbstractWidget() {
        init();
    }


    /**
     * Get element from current widget
     * @param element element in widget
     * @return
     */
    public SelenideElement getElement(String element) {
        SelenideElement selenideElement;
        try {
            selenideElement = widgets.get(currentWidget).elements.get(element.toLowerCase());
        } catch (NullPointerException e) {
            throw new ArgumentNotFoundException(String.format("Не найден элемент \"%s\" в виджете \"%s\"", element, currentWidget));
        }
        return selenideElement;
    }

    /**
     * Get element from new widget
     * @param element element in widget
     * @param widget new widget
     * @return
     */
    public SelenideElement getElement(String element, String widget) {
        setContext(widget);
        return getElement(element);
    }

    /**
     * Get list from current widget
     * @param list list in widget
     * @return
     */
    public ElementsCollection getList(String list) {
        ElementsCollection elementsCollection;
        try {
            elementsCollection = widgets.get(currentWidget).lists.get(list.toLowerCase());
        } catch (NullPointerException e) {
            throw new ArgumentNotFoundException(String.format("Не найден список \"%s\" в виджете \"%s\"", list, currentWidget));
        }
        return elementsCollection;
    }

    /**
     * Get list from new widget
     * @param list list in widget
     * @param widget new widget
     * @return
     */
    public ElementsCollection getList(String list, String widget) {
        setContext(widget);
        return  getList(list);
    }

    /**
     * Use context if next element in the same widget. Set context and work in this widget.
     * When you need new widget set it.
     * @param widget save widget to current widget
     */
    private void setContext(String widget) {
        currentWidget = widget.toLowerCase();
    }

    private void clearContext() {
        currentWidget = null;
    }

    /**
     * Form elements initialization
     */
    abstract protected void init();

}
