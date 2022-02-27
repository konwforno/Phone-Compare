package com.example.myapplication.ui.xiaomi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XiaomiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public XiaomiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}