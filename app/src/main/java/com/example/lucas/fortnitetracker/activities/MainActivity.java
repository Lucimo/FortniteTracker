package com.example.lucas.fortnitetracker.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lucas.fortnitetracker.R;
import com.example.lucas.fortnitetracker.adapters.FortniteTrackerAdapter;
import com.example.lucas.fortnitetracker.model.Data;
import com.example.lucas.fortnitetracker.viewmodel.FortniteTrackerViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Data> data;
    private FloatingActionButton btnSearch;
    private EditText etUserForSearch;
    private Spinner sp_platform;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_main);
        data = new ArrayList<>();
        etUserForSearch = findViewById(R.id.editText_search);
        btnSearch = findViewById(R.id.btn_search);
        sp_platform = findViewById(R.id.spinner_platform);


        FortniteTrackerViewModel fortniteTrackerViewModel = ViewModelProviders.of(this).get(FortniteTrackerViewModel.class);
        fortniteTrackerViewModel.getDataMutableLiveData().observe(this, arr_params -> {
            if (arr_params != null) {

                data = arr_params;
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recyclerView.setAdapter(new FortniteTrackerAdapter(data));

            }


        });
        fortniteTrackerViewModel.getData("psn", "ninja");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                fortniteTrackerViewModel.getData(sp_platform.getSelectedItem().toString().trim(), etUserForSearch.getText().toString());
                etUserForSearch.setText("");
            }
        });


    }
}