package com.example.fitnessapp.UI.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.home.rv.WorkoutRVAdapter;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView workoutRV;
    private WorkoutRVAdapter workoutRVAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
            View root = inflater.inflate(R.layout.fragment_home, container, false);

            workoutRV = root.findViewById(R.id.workoutListRV);
            workoutRV.hasFixedSize();
            workoutRV.setLayoutManager(new LinearLayoutManager(getContext()));

            workoutRVAdapter = new WorkoutRVAdapter();
            workoutRV.setAdapter(workoutRVAdapter);

            mViewModel.getExerciseAsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Result>>() {
                @Override
                public void onChanged(List<Result> exercises) {
                    workoutRVAdapter.setDataset((ArrayList<Result>) exercises);
                    workoutRV.setAdapter(workoutRVAdapter);
                }
            });

            return root;

    }



}