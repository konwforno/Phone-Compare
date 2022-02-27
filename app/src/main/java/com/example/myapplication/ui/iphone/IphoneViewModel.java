package com.example.myapplication.ui.iphone;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IphoneViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IphoneViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is huawei fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}