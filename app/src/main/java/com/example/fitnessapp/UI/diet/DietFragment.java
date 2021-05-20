package com.example.fitnessapp.UI.diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fitnessapp.R;

public class DietFragment extends Fragment {

    private DietViewModel dietViewModel;

    public static DietFragment newInstance() {
        return new DietFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        dietViewModel = new ViewModelProvider(this).get(DietViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diet, container, false);

        return root;
    }
}
