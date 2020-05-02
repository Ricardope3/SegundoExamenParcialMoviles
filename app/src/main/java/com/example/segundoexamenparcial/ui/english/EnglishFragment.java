package com.example.segundoexamenparcial.ui.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.segundoexamenparcial.R;

public class EnglishFragment extends Fragment {

    private EnglishViewModel englishViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        englishViewModel =
                ViewModelProviders.of(this).get(EnglishViewModel.class);
        View root = inflater.inflate(R.layout.fragment_english, container, false);
        final TextView textView = root.findViewById(R.id.text_english);
        englishViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}