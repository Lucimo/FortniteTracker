package com.example.lucas.fortnitetrackerv2.service;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.lucas.fortnitetrackerv2.model.FortniteUser;

import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GetDataService {

    String base_url = "https://api.fortnitetracker.com/v1/";

    @Headers({"TRN-Api-Key: 66199ccc-8746-4ccb-a3db-15946456a33b"})
    @GET("profile/{platform}/{epic-nickname}")
    Flowable<FortniteUser> loadFortniteUser(@Path("platform") String platform, @Path("epic-nickname") String epicName);

    @RequiresApi(api = Build.VERSION_CODES.N)
    static GetDataService create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GetDataService.class);
    }

}