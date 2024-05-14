package com.example.gymapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymapp.model.Course;
import com.example.gymapp.model.OrderList;

import java.util.ArrayList;
import java.util.List;

public class orderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCourseList){
            if(OrderList.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }



             ListView orders_list = findViewById(R.id.orders_list);
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }

}
