package com.example.gymapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.gymapp.model.OrderList;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLvl = findViewById(R.id.coursePageLvl);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLvl.setText(getIntent().getStringExtra("courseLvl"));
        courseText.setText(getIntent().getStringExtra("courseText"));
        }

        public void addToCard(View view) {
            int item_id = getIntent().getIntExtra("courseId",0);
            OrderList.items_id.add(item_id);
            Toast.makeText(this,"Додано",Toast.LENGTH_LONG).show();
        }
}