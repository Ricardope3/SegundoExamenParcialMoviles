package com.example.segundoexamenparcial.ui.sci;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SciViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SciViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sci-fi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}