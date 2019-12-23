package core.widget;

import widgets.*;
import widgets.newAdvertisment.*;
import widgets.searchCar.ResultItem;
import widgets.searchCar.SearchCar;

public class WidgetStorage extends AbstractWidget {

    public WidgetStorage(String contextPath) {
        super(contextPath);

        widgets.put("main", new MainPage(getContextPath()));
        widgets.put("select company", new SelectCompany(getContextPath()));
        widgets.put("select model", new SelectModel(getContextPath()));
        widgets.put("select year", new SelectYear(getContextPath()));
        widgets.put("add advertisement", new AddAdvertisement(getContextPath()));

        widgets.put("progress bar", new ProgressBar(getContextPath()));

        widgets.put("search car", new SearchCar(getContextPath()));
        widgets.put("result item", new ResultItem(getContextPath(), getCurrentWidgetNumber()));
    }


    @Override
    protected void init() {

    }
}