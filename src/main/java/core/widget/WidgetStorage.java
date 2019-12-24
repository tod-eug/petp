package core.widget;

import widgets.*;
import widgets.newAdvertisment.*;
import widgets.searchCar.Filter;
import widgets.searchCar.ResultItem;
import widgets.searchCar.SearchCar;

public class WidgetStorage extends AbstractWidget {

    public WidgetStorage(String contextPath) {
        super(contextPath);

        widgets.put("main", new MainPage(contextPath));
        widgets.put("select company", new SelectCompany(contextPath));
        widgets.put("select model", new SelectModel(contextPath));
        widgets.put("select year", new SelectYear(contextPath));
        widgets.put("add advertisement", new AddAdvertisement(contextPath));

        widgets.put("progress bar", new ProgressBar(contextPath));

        widgets.put("search car", new SearchCar(contextPath));
        widgets.put("filter", new Filter(contextPath));
        widgets.put("result item", new ResultItem(getContextPathToGettingWidget(), getCurrentWidgetNumber()));
    }


    @Override
    protected void init() {

    }
}