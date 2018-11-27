package com.example.lucas.fortnitetracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.lucas.fortnitetracker.model.Data;
import com.example.lucas.fortnitetracker.model.FortniteUser;
import com.example.lucas.fortnitetracker.repository.FortniteTrackerRepository;

import java.util.ArrayList;

import io.reactivex.schedulers.Schedulers;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FortniteTrackerViewModel extends AndroidViewModel {



    private MutableLiveData<FortniteUser> fortniteUserMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Data>> dataUserMutableLiveData = new MutableLiveData<>();
    private FortniteTrackerRepository fortniteTrackerRepository =  FortniteTrackerRepository.getInstance();
    private ArrayList<Data> arr_parameters = new ArrayList<>();


    public FortniteTrackerViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<ArrayList<Data>> getDataMutableLiveData() {
        return dataUserMutableLiveData;
    }


    public MutableLiveData<FortniteUser> getServiceDataMutableLiveData() {
        return fortniteUserMutableLiveData;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getData(String platform, String epicName) {
        fortniteTrackerRepository.getFortniteUser(platform, epicName)
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                            arr_parameters.add(response.getStats().getStatsDetails().getWinRatio());
                            arr_parameters.add(response.getStats().getStatsDetails().getMatches());
                            arr_parameters.add(response.getStats().getStatsDetails().getKd());
                            arr_parameters.add(response.getStats().getStatsDetails().getKills());
                           dataUserMutableLiveData.postValue(arr_parameters);
                        },
                        error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));


    }
}
