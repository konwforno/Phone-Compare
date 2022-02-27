package com.example.myapplication.ui.oneplus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OneplusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OneplusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is huawei fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}