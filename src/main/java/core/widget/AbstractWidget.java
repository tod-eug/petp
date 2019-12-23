package core.widget;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.exceptions.ArgumentNotFoundException;

import java.util.HashMap;
import java.util.regex.Pattern;

public abstract class AbstractWidget {

    protected HashMap<String, AbstractWidget> widgets = new HashMap<>();
    protected HashMap<String, SelenideElement> elements = new HashMap<>();
    protected HashMap<String, ElementsCollection> lists = new HashMap<>();

    protected SelenideElement contextDom = null;

    private String getWidgetFromWidgets;
    private Integer setNumberToGettingWidget;
    private String setContextPathToGettingWidget;

    private String currentWidget = "";
    private Integer currentWidgetNumber = 0;
    private String contextPath = "";


    /**
     * This constructor create widget with context
     *
     * @param contextPath context from test
     */
    public AbstractWidget(String contextPath) {
        if (contextPath != null) {
            parseContextWidget(contextPath);
        }
        init();
    }

    /**
     * This constructor, create widget with context element
     *
     * @param path       context widget
     * @param contextDom dom element
     */
    public AbstractWidget(String path, SelenideElement contextDom) {
        setContext(path);
        this.contextDom = contextDom;
        init();
    }

    /**
     * This constructor create widget contains list of widgets
     *
     * @param path                context widget
     * @param currentWidgetNumber widget number
     */
    public AbstractWidget(String path, int currentWidgetNumber) {
        setContext(path);
        this.currentWidgetNumber = currentWidgetNumber;
        init();
    }

    /**
     * This constructor create widget contains list of widgets with context element
     *
     * @param path                context widget
     * @param currentWidgetNumber widget number
     * @param contextDom          dom element
     */
    public AbstractWidget(String path, int currentWidgetNumber, SelenideElement contextDom) {
        setContext(path);
        this.contextDom = contextDom;
        this.currentWidgetNumber = currentWidgetNumber;
        init();
    }

    private void parseContextWidget(String context) {
        getWidgetFromWidgets = Pattern.compile("^([А-Яа-яЁё \\-A-Za-z]+)").matcher(context).toString().toLowerCase();
        setNumberToGettingWidget = Integer.parseInt(Pattern.compile("[0-9]+").matcher(context).toString());
        if (setNumberToGettingWidget != null) setNumberToGettingWidget = setNumberToGettingWidget - 1;

        if (context.contains("/")) {
            setContextPathToGettingWidget = context.replaceFirst("$getWidgetFromWidgets", "");
            if (setContextPathToGettingWidget.substring(0, 1).equals("[")) {
                setContextPathToGettingWidget = setContextPathToGettingWidget.replaceFirst("[${setNumberToGettingWidget + 1}]/", "").toLowerCase();
            } else {
                setContextPathToGettingWidget.replaceFirst("/", "").toLowerCase();
            }
        }
    }

    /**
     * Get element from current widget
     * @param element element in widget
     * @return element
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
     * Get context
     * Context is a dom element which used for looking next element not from root element, but from current
     *
     * @return context
     */
    public String getContextPath() {
        return contextPath;
    }

    public int getCurrentWidgetNumber() {
        return currentWidgetNumber;
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
