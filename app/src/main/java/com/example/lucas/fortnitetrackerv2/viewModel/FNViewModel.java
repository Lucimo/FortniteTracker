package com.example.lucas.fortnitetrackerv2.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.example.lucas.fortnitetrackerv2.model.Data;
import com.example.lucas.fortnitetrackerv2.model.FortniteUser;
import com.example.lucas.fortnitetrackerv2.repository.FNRepository;
import java.util.ArrayList;
import io.reactivex.schedulers.Schedulers;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FNViewModel extends ViewModel {

    private FNRepository fnRepository = FNRepository.getInstance();
    private MutableLiveData<FortniteUser> fnUserLiveData = new MutableLiveData<>();
    private MutableLiveData<FortniteUser> fortniteUserMutableLiveData;

    private ArrayList<Data>  dataArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<Data>> dataUserMutableLiveData = new MutableLiveData<ArrayList<Data>>();

    public FNViewModel() {
        fortniteUserMutableLiveData = new MutableLiveData<>();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getData(String platform, String epicName) {
       FNRepository.getFortniteUser(platform, epicName)

                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                            dataArrayList.add(response.getStats().getStatsDetails().getWinRatio());
                            dataArrayList.add(response.getStats().getStatsDetails().getMatches());
                            dataArrayList.add(response.getStats().getStatsDetails().getKd());
                            dataArrayList.add(response.getStats().getStatsDetails().getKills());

                            dataUserMutableLiveData.postValue( dataArrayList);
                        },
                        error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));


    }
    public MutableLiveData<ArrayList<Data>> getDataMutableLiveData(){
        return  dataUserMutableLiveData;
    }
}
