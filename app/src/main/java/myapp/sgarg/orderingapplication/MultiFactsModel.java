package myapp.sgarg.orderingapplication;

import java.util.List;

public class MultiFactsModel {

    private int current_page;
    private List<ModelData> data;

    public int getCurrent_page() {
        return current_page;
    }

    public List<ModelData> getData() {
        return data;
    }
}
