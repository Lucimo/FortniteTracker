package com.example.lucas.fortnitetracker.repository;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lucas.fortnitetracker.R;

public class FortniteTrackerCellViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_first;
    public TextView tv_second;
    public TextView tv_third;

    public FortniteTrackerCellViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_first = itemView.findViewById(R.id.txt_label);
        tv_second= itemView.findViewById(R.id.txt_value);
        tv_third = itemView.findViewById(R.id.txt_rank);




    }


}