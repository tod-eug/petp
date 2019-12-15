package core.widget;

import widgets.*;

public class WidgetStorage extends AbstractWidget {

    public WidgetStorage() {
        super();

        widgets.put("main", new MainPage());
        widgets.put("select company", new SelectCompany());
        widgets.put("select model", new SelectModel());
        widgets.put("select year", new SelectYear());
        widgets.put("add advertisement", new AddAdvertisement());

        widgets.put("progress bar", new ProgressBar());
    }


    @Override
    protected void init() {

    }
}
