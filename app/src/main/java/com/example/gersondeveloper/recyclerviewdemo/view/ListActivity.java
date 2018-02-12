package com.example.gersondeveloper.recyclerviewdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gersondeveloper.recyclerviewdemo.R;
import com.example.gersondeveloper.recyclerviewdemo.data.FakeDataSource;
import com.example.gersondeveloper.recyclerviewdemo.data.ListItem;
import com.example.gersondeveloper.recyclerviewdemo.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface {


    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOdData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        //this is dependency injection
        controller = new Controller(this, new FakeDataSource());

    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent i = new Intent(this, DetailActtivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        i.putExtra(EXTRA_MESSAGE, message);
        i.putExtra(EXTRA_COLOR, colorResource);

        startActivity(i);

    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOdData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter();
        recyclerView.setAdapter(customAdapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ListItem currentItem = listOdData.get(position);

            //inflate each item with property content
            holder.coloredCircle.setBackgroundResource(currentItem.getColorResource());
            holder.dateAndTime.setText(currentItem.getMessage());
            holder.message.setText(currentItem.getMessage());

        }

        @Override
        public int getItemCount() {
            //helps adapter decide how many items it will need to manage
            return listOdData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private View coloredCircle;
            private TextView dateAndTime, message;
            private ViewGroup container;

            public MyViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOdData.get(this.getAdapterPosition());

                controller.onListItemClicked(listItem);
            }
        }
    }


}
