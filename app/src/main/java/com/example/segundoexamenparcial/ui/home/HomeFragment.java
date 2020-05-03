package com.example.segundoexamenparcial.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.segundoexamenparcial.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Context contexto;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        contexto = getActivity();

        return root;
    }

}