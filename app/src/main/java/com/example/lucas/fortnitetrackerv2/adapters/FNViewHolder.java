package com.example.lucas.fortnitetrackerv2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.lucas.fortnitetrackerv2.R;
public class FNViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_first;
    public TextView tv_second;
    public TextView tv_third;

    public FNViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_first = itemView.findViewById(R.id.txt_label);
        tv_second = itemView.findViewById(R.id.txt_value);
        tv_third = itemView.findViewById(R.id.txt_rank);


    }

    public void setTv_first(TextView tv_first) {
        this.tv_first = tv_first;
    }

    public void setTv_second(TextView tv_second) {
        this.tv_second = tv_second;
    }

    public void setTv_third(TextView tv_third) {
        this.tv_third = tv_third;
    }
}
