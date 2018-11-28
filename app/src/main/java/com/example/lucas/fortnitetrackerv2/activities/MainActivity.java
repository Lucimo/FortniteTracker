package com.example.lucas.fortnitetrackerv2.activities;

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


import com.example.lucas.fortnitetrackerv2.R;
import com.example.lucas.fortnitetrackerv2.adapters.FNAdapter;
import com.example.lucas.fortnitetrackerv2.model.Data;
import com.example.lucas.fortnitetrackerv2.viewModel.FNViewModel;

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
        sets();
        search();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void search() {
        FNViewModel fnViewModel = ViewModelProviders.of(this).get(FNViewModel.class);
        fnViewModel.getDataMutableLiveData().observe(this, arr_params -> {
            if (arr_params != null) {

                data = arr_params;
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recyclerView.setAdapter(new FNAdapter(data));

            }


        });

        fnViewModel.getData("psn", "ninja");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                fnViewModel.getData(sp_platform.getSelectedItem().toString().trim(), etUserForSearch.getText().toString());
            }
        });

    }

    private void sets() {
        recyclerView = findViewById(R.id.recyclerView_main);
        data = new ArrayList<>();
        etUserForSearch = findViewById(R.id.editText_search);
        btnSearch = findViewById(R.id.search_btn);
        sp_platform = findViewById(R.id.spinner_platform);
    }
}
