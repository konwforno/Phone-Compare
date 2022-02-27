package com.example.myapplication.ui.vivo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VivoViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public VivoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is samsung fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}