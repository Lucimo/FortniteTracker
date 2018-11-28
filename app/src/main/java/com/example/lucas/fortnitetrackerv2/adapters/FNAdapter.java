package com.example.lucas.fortnitetrackerv2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lucas.fortnitetrackerv2.R;
import com.example.lucas.fortnitetrackerv2.model.Data;

import java.util.ArrayList;

public class FNAdapter extends RecyclerView.Adapter<FNViewHolder> {
    private ArrayList<Data> data;

    public FNAdapter(ArrayList<Data> data) {
        this.data = data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FNViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view_row, null);
        FNViewHolder fnViewHolder = new FNViewHolder(view);
        return fnViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FNViewHolder fnViewHolder, int position) {
        Data item = data.get(position);

        fnViewHolder.tv_first.setText(item.getLabel());
        fnViewHolder.tv_third.setText(item.getRank());
        fnViewHolder.tv_second.setText(item.getValue());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
