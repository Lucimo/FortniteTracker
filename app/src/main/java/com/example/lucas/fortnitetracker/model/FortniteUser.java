package com.example.lucas.fortnitetracker.model;



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
