package com.example.lucas.fortnitetrackerv2.model;


import com.example.lucas.fortnitetrackerv2.model.StatsDetails;

public class Stats {
    private StatsDetails p2;

    public Stats(StatsDetails statsDetails) {
        this.p2 = statsDetails;
    }

    public StatsDetails getStatsDetails() {
        return p2;
    }

    public void setStatsDetails(StatsDetails statsDetails) {
        this.p2 = statsDetails;
    }
}
