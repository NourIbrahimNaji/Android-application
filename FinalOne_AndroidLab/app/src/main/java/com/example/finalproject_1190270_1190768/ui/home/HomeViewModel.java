package com.example.finalproject_1190270_1190768.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_1190270_1190768.DataBaseHelper;
import com.example.finalproject_1190270_1190768.Part2;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("A Country in Continent <" +DataBaseHelper.inputUser.getPtdestinations() + ">\n"+
               "- Destination Id: " + DataBaseHelper.homeDes.getDestination_id() +"\n- City: " + DataBaseHelper.homeDes.getCity() +"\n- Country: " +  DataBaseHelper.homeDes.getCountry() +"\n- Continent: " + DataBaseHelper.homeDes.getContinent() +
                "\n- Longitude: " + DataBaseHelper.homeDes.getLongitude() + "\n- Latitude: " + DataBaseHelper.homeDes.getLatitude() + "\n- Cost: " + DataBaseHelper.homeDes.getCost()  + "\n- Description: " + DataBaseHelper.homeDes.getDescription());
    }

    public LiveData<String> getText() {
        return mText;
    }

}