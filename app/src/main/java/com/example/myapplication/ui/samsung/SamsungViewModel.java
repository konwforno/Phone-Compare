package com.example.myapplication.ui.samsung;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SamsungViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public SamsungViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is samsung fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}