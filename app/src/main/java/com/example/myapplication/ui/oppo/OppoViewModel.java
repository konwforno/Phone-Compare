package com.example.myapplication.ui.oppo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OppoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OppoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is huawei fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}