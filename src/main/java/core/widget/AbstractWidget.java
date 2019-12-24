package core.widget;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.exceptions.ArgumentNotFoundException;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractWidget {

    protected HashMap<String, AbstractWidget> widgets = new HashMap<>();
    protected HashMap<String, SelenideElement> elements = new HashMap<>();
    protected HashMap<String, ElementsCollection> lists = new HashMap<>();

    private String getWidgetFromWidgets;
    private String setContextPathToGettingWidget;

    protected SelenideElement contextDom = null;
    private Integer currentWidgetNumber = 0;


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
     * This constructor create widget contains list of widgets
     *
     * @param path                context widget
     * @param currentWidgetNumber widget number
     */
    public AbstractWidget(String path, int currentWidgetNumber) {
        this(path);
        this.currentWidgetNumber = currentWidgetNumber;
        init();
    }


    /**
     * Parsing context from widget
     * @param context
     */
    private void parseContextWidget(String context) {
        Pattern pattern;
        Matcher matcher;
        String[] args;
        String delimeter = "/";

        args = context.toLowerCase().split(delimeter);
        currentWidgetNumber = 0;

        if (args.length > 1) {
            if (args[1].matches("(.*)\\[[0-9]+\\]$")) {
                pattern = Pattern.compile("\\[([0-9]+)\\]$");
                matcher = pattern.matcher(args[1]);
                if (matcher.find()) {
                    currentWidgetNumber = Integer.parseInt(matcher.group(1)) - 1;
                }
            }
            pattern = Pattern.compile("[A-z ]+$");
            matcher = pattern.matcher(args[0]);
            if (matcher.find()) {
                getWidgetFromWidgets = matcher.group(0);
            }
            setContextPathToGettingWidget =
                    args[1].toLowerCase()
                            .replaceFirst("[0-9]+", "")
                            .replace("[", "")
                            .replace("]", "");
        } else {
            getWidgetFromWidgets = args[0];
        }
    }

    /**
     * Get element from widget
     * @param element element in widget
     * @return SelenideElement
     */
    public SelenideElement getElement(String element) {
        SelenideElement selenideElement;
         if (setContextPathToGettingWidget != null) {
             try {
                selenideElement = widgets.get(setContextPathToGettingWidget).elements.get(element.toLowerCase());
             } catch (NullPointerException e) {
                throw new ArgumentNotFoundException(String.format("Element \"%s\" not found in widget \"%s\"", element, setContextPathToGettingWidget));
            }
         } else {
             try {
                 selenideElement = widgets.get(getWidgetFromWidgets).elements.get(element.toLowerCase());
             } catch (NullPointerException e) {
                 throw new ArgumentNotFoundException(String.format("Element \"%s\" not found in widget \"%s\"", element, getWidgetFromWidgets));
             }
         }
        return selenideElement;
    }

    /**
     * Get list from widget
     * @param list list in widget
     * @return ElementsCollection
     */
    public ElementsCollection getList(String list) {
        ElementsCollection elementsCollection;
        if (setContextPathToGettingWidget != null) {
            try {
                elementsCollection = widgets.get(setContextPathToGettingWidget).lists.get(list.toLowerCase());
            } catch (NullPointerException e) {
                throw new ArgumentNotFoundException(String.format("List \"%s\" not found in widget \"%s\"", list, setContextPathToGettingWidget));
            }
        } else {
            try {
                elementsCollection = widgets.get(getWidgetFromWidgets).lists.get(list.toLowerCase());
            } catch (NullPointerException e) {
                throw new ArgumentNotFoundException(String.format("List \"%s\" not found in widget \"%s\"", list, getWidgetFromWidgets));
            }
        }
        return elementsCollection;
    }

    /**
     * Get context for countable widget
     * @return contextPath
     */
    public String getContextPathToGettingWidget() {
        return setContextPathToGettingWidget;
    }

    /**
     * Get current widget number for using in locators
     * @return widget number
     */
    public int getCurrentWidgetNumber() {
        return currentWidgetNumber;
    }


    /**
     * Form elements initialization
     */
    abstract protected void init();

}
