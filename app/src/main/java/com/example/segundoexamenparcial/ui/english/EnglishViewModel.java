package com.example.segundoexamenparcial.ui.english;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnglishViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EnglishViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is english fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}