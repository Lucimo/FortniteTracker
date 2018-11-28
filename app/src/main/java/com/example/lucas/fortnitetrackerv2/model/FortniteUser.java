package com.example.lucas.fortnitetrackerv2.model;


import com.example.lucas.fortnitetrackerv2.model.Stats;

public class FortniteUser {

    private Stats stats;

    public FortniteUser(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
