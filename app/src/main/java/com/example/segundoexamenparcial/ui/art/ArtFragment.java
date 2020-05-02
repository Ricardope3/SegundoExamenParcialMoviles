package com.example.segundoexamenparcial.ui.art;

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

public class ArtFragment extends Fragment {

    private ArtViewModel artViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        artViewModel =
                ViewModelProviders.of(this).get(ArtViewModel.class);
        View root = inflater.inflate(R.layout.fragment_art, container, false);
        final TextView textView = root.findViewById(R.id.text_art);
        artViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}