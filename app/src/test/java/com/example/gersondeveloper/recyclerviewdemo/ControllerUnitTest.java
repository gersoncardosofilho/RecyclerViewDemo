package com.example.gersondeveloper.recyclerviewdemo;

import com.example.gersondeveloper.recyclerviewdemo.data.DataSourceInterface;
import com.example.gersondeveloper.recyclerviewdemo.data.ListItem;
import com.example.gersondeveloper.recyclerviewdemo.logic.Controller;
import com.example.gersondeveloper.recyclerviewdemo.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
                R.color.BLUE
    );

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuiccessfull() {

        //Set up any data for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //Set up our mocks to return the data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        //Call the method(unit) we are testing
        controller.getListFromDataSource();

        //Check how the tested class responds to the data it receives
        //or test it's behavior
        Mockito.verify(view).setUpAdapterAndView(listOfData);

        // @Test
        // public void onGetListDataUnsuccessful() {
        /**************************
         *
         * Unit Test Homework:
         *
         * Implement the "View", so that when we don't recieve a List, it shows some kind of
         * error message to the user. This is common practice that you should learn!
         *
         * I've written some hints you'll have to decipher into Java code:
         *************************/
        //1 Set up your Mock dataSource

        //2 Call the method you wish to test on the Controller

        //3 Verify that the View has been told to show a message (I'd suggest showing a Toast for now)

        //Profit???

        // }



    }
}