package com.example.gersondeveloper.recyclerviewdemo.logic;

import com.example.gersondeveloper.recyclerviewdemo.data.DataSourceInterface;
import com.example.gersondeveloper.recyclerviewdemo.data.ListItem;
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
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void onListItemClicked(ListItem listItem){
        view.startDetailActivity(
        listItem.getDateAndTime(),
        listItem.getMessage(),
        listItem.getColorResource()
        );
    }
}
