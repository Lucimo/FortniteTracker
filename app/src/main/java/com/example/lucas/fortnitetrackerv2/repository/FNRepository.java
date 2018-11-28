package com.example.lucas.fortnitetrackerv2.repository;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.lucas.fortnitetrackerv2.model.FortniteUser;
import com.example.lucas.fortnitetrackerv2.service.GetDataService;

import io.reactivex.Flowable;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FNRepository {
    private static FNRepository instance;

    public static FNRepository getInstance() {
        if (instance == null) {
            synchronized (FNRepository.class) {
                if (instance == null) {
                    instance = new FNRepository();
                }
            }
        }

        return instance;
    }


    private static GetDataService fnApi = GetDataService.create();


    public static Flowable<FortniteUser> getFortniteUser(String platform, String epicName) {
        return fnApi.loadFortniteUser(platform, epicName);
    }

    private FNRepository() {
    }
}