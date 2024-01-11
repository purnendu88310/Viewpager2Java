package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 myViewPager2;
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager2 = findViewById(R.id.viewPager2);

        myAdapter = new Adapter(getSupportFragmentManager(), getLifecycle());


        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        myViewPager2.setAdapter(myAdapter);


        createAllFragments();
    }

    private void createAllFragments(){
        for (StudentModel model:getStudentList()
             ) {
            myAdapter.addFragment(StudentFragment.newInstance(model.getName(),model.getSubject()));

        }

    }


    private List<StudentModel> getStudentList(){
        List<StudentModel> list = new ArrayList<>();
        list.add(new StudentModel("Purnendu","Android"));
        list.add(new StudentModel("Rishabh","Android"));
        list.add(new StudentModel("Jovan","IOS"));
        list.add(new StudentModel("Amit","IOS"));


return list;
    }
}