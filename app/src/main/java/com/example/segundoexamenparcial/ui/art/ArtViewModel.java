package com.example.segundoexamenparcial.ui.art;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArtViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is art fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}