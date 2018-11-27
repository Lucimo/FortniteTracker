package com.example.lucas.fortnitetracker.adapters;

import android.database.Observable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.lucas.fortnitetracker.R;
import com.example.lucas.fortnitetracker.model.Data;
import com.example.lucas.fortnitetracker.model.FortniteUser;
import com.example.lucas.fortnitetracker.repository.FortniteTrackerCellViewHolder;

import java.util.ArrayList;

import io.reactivex.Flowable;


public class FortniteTrackerAdapter extends RecyclerView.Adapter<FortniteTrackerCellViewHolder> {
    private ArrayList<Data> data;

    public FortniteTrackerAdapter(ArrayList<Data> data) {
        this.data = data;


    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FortniteTrackerCellViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view_row, null);
        FortniteTrackerCellViewHolder fortniteTrackerCellViewHolder = new FortniteTrackerCellViewHolder(view);
        return fortniteTrackerCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FortniteTrackerCellViewHolder fortniteTrackerCellViewHolder, int position) {

        Data item = data.get(position);

        fortniteTrackerCellViewHolder.tv_first.setText(item.getLabel());
        fortniteTrackerCellViewHolder.tv_third.setText(item.getRank());
        fortniteTrackerCellViewHolder.tv_second.setText(item.getValue());


    }

    @Override
    public int getItemCount() {
        return data.size();

    }


}