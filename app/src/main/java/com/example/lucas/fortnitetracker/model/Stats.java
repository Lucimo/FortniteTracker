package com.example.lucas.fortnitetracker.model;



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
