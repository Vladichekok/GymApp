package com.example.gymapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.adapter.CategoryAdapter;
import com.example.gymapp.adapter.CourseAdapter;
import com.example.gymapp.model.Category;
import com.example.gymapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    @SuppressLint("StaticFieldLeak")
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Верх"));
        categoryList.add(new Category(2,"Низ"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1,"chest","День грудей", "1 місяць", "Для новачків", "#595B5D", "Груди - одна з найбільш великих і красивих мязових груп в людському організмі.В даному курсі присвяченому для тренування мязів грудей, ми розглянемо комплекс вправ, які ефективно сприяють розвитку грудних мязів",1));
        courseList.add(new Course(2,"biceps","День біцепсу", "1 місяць", "Для новачків", "#9FA52D", "Сильний біцепс посилає просте повідомлення: ви працюєте над своїм тілом. Однак вам не обов’язково проводити день за днем, виконуючи одні й ті самі вправи. Завжди краще віддати перевагу якості, ніж кількості, і прислухатися до порад, коли йдеться про комплексну роботу над цими м’язами.",1));
        courseList.add(new Course(3,"back","День спини", "1 місяць", "Для новачків", "#A020F0", "Вправи для м'язів спини спрямовані для розвитку однієї з наймасивніших м'язових груп в тілі людини. Однак, у багатьох людей спина є відстаючим місцем на тлі інших м'язів.",1));
        courseList.add(new Course(4,"shoulders","День плечей", "1 місяць", "Для новачків", "#d8031c", "Плечі - це одна з найпопулярніших м'язових груп, яку прагнути накачати і збільшити в обсязі буквально кожен чоловік відвідує тренажерний зал. Пов'язано це з тим, що красиві і широкі плечі у чоловіка — одне з головних достоїнств, на яке звертають увагу оточуючі. Красиві і злегка підкачані плечі у дівчат, надають їй велику сексуальність і красу фігури.",1));
        courseList.add(new Course(5,"leg","День ніг", "1 місяць", "Для новачків", "#01016f", "Вправи для ніг - це система ефективних вправ, яка дозволить створити чоловікам потужні і сильні ноги, а дівчатам стрункі і підтягнуті.",2));
        courseList.add(new Course(6,"triceps","День тріцепсу", "1 місяць", "Для новачків", "#ff9a00", "Трицепс становить приблизно 2/3 маси руки. Таким чином, він відіграє більш важливу роль у формуванні об’єму верхніх кінцівок, ніж біцепс. У цьому курсі ми розповімо про ефективні вправи, які допоможуть вам підтягнути, зміцнити та розвинути тріцепс.",1));

        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openCourseCard(View view){

        Intent intent = new Intent(this,orderPage.class);
        startActivity(intent);
    }




    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showCoursesByCategory(int category){

       courseList.clear();
        courseList.addAll(fullCourseList);

            List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList){
            if (c.getCategory() == category){
                filterCourses.add(c);
            }
        }
        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
            }
}
