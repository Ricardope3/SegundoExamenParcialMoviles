package com.example.segundoexamenparcial.ui.comics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.segundoexamenparcial.R;

public class ComicsFragment extends Fragment {

    private ComicsViewModel comicsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        comicsViewModel =
                ViewModelProviders.of(this).get(ComicsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sports, container, false);
        final TextView textView = root.findViewById(R.id.text_sports);
        comicsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}