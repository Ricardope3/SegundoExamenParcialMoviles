package com.example.segundoexamenparcial.ui.self;

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

public class SelfFragment extends Fragment {

    private SelfViewModel selfViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        selfViewModel =
                ViewModelProviders.of(this).get(SelfViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sci, container, false);
        final TextView textView = root.findViewById(R.id.text_sci);
        selfViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}