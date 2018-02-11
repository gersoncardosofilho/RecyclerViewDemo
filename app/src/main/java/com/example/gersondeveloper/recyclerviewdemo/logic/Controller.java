package com.example.gersondeveloper.recyclerviewdemo.logic;

import com.example.gersondeveloper.recyclerviewdemo.data.DataSourceInterface;
import com.example.gersondeveloper.recyclerviewdemo.view.ViewInterface;

/**
 * Created by gerso on 2/11/2018.
 */

public class Controller {
    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }


    public void getListFromDataSource() {

    }
}
