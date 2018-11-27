package com.example.lucas.fortnitetracker.repository;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.lucas.fortnitetracker.model.FortniteUser;
import com.example.lucas.fortnitetracker.service.GetStatsDataService;

import io.reactivex.Flowable;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FortniteTrackerRepository {
    private static FortniteTrackerRepository instance;
    private FortniteTrackerRepository() {
    }

    public static FortniteTrackerRepository getInstance() {
        if (instance == null){
            synchronized (FortniteTrackerRepository.class){
                if (instance == null){
                    instance = new FortniteTrackerRepository();
                }
            }
        }

        return instance;
    }


    private GetStatsDataService apiService = GetStatsDataService.create();


    public Flowable<FortniteUser> getFortniteUser(String platform, String epicName) {
        return apiService.loadFortniteUser(platform, epicName);
    }


}