package com.rohit.sample.Controller;

import com.rohit.sample.Adapters.DataModel;
import com.rohit.sample.Model.MainModel;
import com.rohit.sample.View.MainActivity;

public class MainController {
    private MainActivity mainActivity;
    private MainModel model;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.model = new MainModel(mainActivity.getApplicationContext(), this);
    }

    public void getImage() {
        model.getData();
    }

    public void getImageUrl(DataModel dataModel) {
        this.mainActivity.setUrl(dataModel);
    }
}