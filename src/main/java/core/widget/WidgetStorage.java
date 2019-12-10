package core.widget;

import widgets.SelectCompany;

public class WidgetStorage extends AbstractWidget {

    public WidgetStorage() {
        super();

        widgets.put("select company", new SelectCompany());
    }


    @Override
    protected void init() {

    }
}
