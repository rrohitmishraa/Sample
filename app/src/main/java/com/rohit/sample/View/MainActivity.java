package com.rohit.sample.View;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rohit.sample.Adapters.DataModel;
import com.rohit.sample.Adapters.RecyclerAdapter;
import com.rohit.sample.Controller.MainController;
import com.rohit.sample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MainController controller;
    ArrayList<DataModel> data;
    RecyclerAdapter adapter;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        data = new ArrayList<>();

        controller = new MainController(this);
        controller.getImage();
    }

    public void setUrl(DataModel dataModel) {
        data.add(dataModel);

        b.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, data);
        b.recyclerView.setAdapter(adapter);
    }
}