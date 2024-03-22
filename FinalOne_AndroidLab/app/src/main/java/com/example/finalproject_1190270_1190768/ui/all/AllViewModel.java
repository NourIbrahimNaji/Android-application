package com.example.finalproject_1190270_1190768.ui.all;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AllViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
