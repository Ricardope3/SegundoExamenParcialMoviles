package com.example.segundoexamenparcial.ui.self;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelfViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SelfViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is self-help fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}