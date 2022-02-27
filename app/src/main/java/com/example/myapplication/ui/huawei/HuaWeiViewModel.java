package com.example.myapplication.ui.huawei;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HuaWeiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HuaWeiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is huawei fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}