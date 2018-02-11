package com.example.gersondeveloper.recyclerviewdemo.view;

import com.example.gersondeveloper.recyclerviewdemo.data.ListItem;

import java.util.List;

/**
 * Created by Gerson on 2/11/2018.
 */

public interface ViewInterface {
    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setUpAdapterAndView(List<ListItem>listOfData);
}
