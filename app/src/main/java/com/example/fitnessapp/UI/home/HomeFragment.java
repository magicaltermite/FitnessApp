package com.example.fitnessapp.UI.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private TextView textView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textView = requireView().findViewById(R.id.APITextView);
        textView.setText(mViewModel.getExerciseAsLiveData().toString());

        mViewModel.getExerciseAsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

            }
        });

        return root;
    }



}