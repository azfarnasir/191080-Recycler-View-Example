package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recyclerviewexample.Adapter.RecyclerViewAdapter;
import com.example.recyclerviewexample.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> studentDetails = new ArrayList<>();
    RecyclerView rv;
    RecyclerViewAdapter rva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDetails.add(new Student("GEORGE","101010"));
        studentDetails.add(new Student("ROBIN","202020"));
        studentDetails.add(new Student("KATHERINE","303030"));
        studentDetails.add(new Student("LANGFORD","404040"));
        studentDetails.add(new Student("EMMA","505050"));
        studentDetails.add(new Student("ALAN","606060"));
        studentDetails.add(new Student("OTASH","707070"));
        studentDetails.add(new Student("VISHI","808080"));
        studentDetails.add(new Student("ALBERT","909090"));
        rva = new RecyclerViewAdapter(MainActivity.this,studentDetails);
        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rva);
    }
}