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

    private EditText etNickName;
    private Spinner spinnerPlataform;
    private FortniteTrackerAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnFind;
    private FortniteTrackerViewModel fortniteViewModel;
    private String platform;
    private String epicName;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        etNickName = findViewById(R.id.editText_search);
        spinnerPlataform = findViewById(R.id.spinner_platform);
        btnFind = findViewById(R.id.btn_search);

        changeData("","");

        clickbtnFind();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void changeData(String platform, String epicName){
        fortniteViewModel = ViewModelProviders.of(this).get(FortniteTrackerViewModel.class);
        fortniteViewModel.getDataMutableLiveData().observe(this, Data -> {
            if(Data!=null){
                Log.d("ServiceFornite","Changes: "+ Data);
                generateForniteList(Data);
            }
        });
        fortniteViewModel.getData(platform, epicName);
    }

    private void generateForniteList(ArrayList<Data> data) {
        recyclerView = findViewById(R.id.recyclerView_main);
        adapter = new FortniteTrackerAdapter(data);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void clickbtnFind(){
        btnFind.setOnClickListener(v -> {
            platform = spinnerPlataform.getSelectedItem().toString();
            epicName = etNickName.getText().toString();
            Log.d("Change","platform "+platform+" epic_name "+epicName);
            fortniteViewModel.getData(platform, epicName);
        });

    }
}

