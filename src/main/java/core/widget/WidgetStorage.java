package core.widget;

import widgets.MainPage;
import widgets.SelectCompany;
import widgets.SelectModel;
import widgets.SelectYear;

public class WidgetStorage extends AbstractWidget {

    public WidgetStorage() {
        super();

        widgets.put("main", new MainPage());
        widgets.put("select company", new SelectCompany());
        widgets.put("select model", new SelectModel());
        widgets.put("select year", new SelectYear());
    }


    @Override
    protected void init() {

    }
}
