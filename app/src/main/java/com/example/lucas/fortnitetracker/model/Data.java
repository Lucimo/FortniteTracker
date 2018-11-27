package com.example.lucas.fortnitetracker.model;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("label")
    private String label;
    @SerializedName("value")
    private String value;
    @SerializedName("rank")
    private String rank;

    public Data(String label, String value, String rank) {
        this.label = label;
        this.value = value;
        this.rank = rank;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
