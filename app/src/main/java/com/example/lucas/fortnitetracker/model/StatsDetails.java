package com.example.lucas.fortnitetracker.model;

import com.google.gson.annotations.SerializedName;

public class StatsDetails {
    @SerializedName("winRatio")
    private Data winRatio;
    @SerializedName("kd")
    private Data kd;
    @SerializedName("kills")
    private Data kills;
    @SerializedName("matches")
    private Data matches;

    public StatsDetails(Data winRatio, Data kd, Data kills, Data matches) {
        this.winRatio = winRatio;
        this.kd = kd;
        this.kills = kills;
        this.matches = matches;
    }

    public Data getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(Data winRatio) {
        this.winRatio = winRatio;
    }

    public Data getKd() {
        return kd;
    }

    public void setKd(Data kd) {
        this.kd = kd;
    }

    public Data getKills() {
        return kills;
    }

    public void setKills(Data kills) {
        this.kills = kills;
    }

    public Data getMatches() {
        return matches;
    }

    public void setMatches(Data matches) {
        this.matches = matches;
    }
}
