package com.example.myapplication.ui.bottom_home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BottomHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BottomHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is huawei fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}