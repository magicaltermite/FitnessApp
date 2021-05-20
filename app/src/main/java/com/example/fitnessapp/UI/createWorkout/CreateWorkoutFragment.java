package com.example.fitnessapp.UI.createWorkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.createWorkout.rv.CreateWorkoutRVAdapter;
import com.example.fitnessapp.UI.home.HomeViewModel;
import com.example.fitnessapp.models.SimpleExercise;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkoutFragment extends Fragment {

    private CreateWorkoutViewModel mViewModel;
    private RecyclerView createWorkoutRV;
    private CreateWorkoutRVAdapter createWorkoutRVAdapter;
    private int i = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CreateWorkoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_workout, container, false);


        createWorkoutRV = root.findViewById(R.id.workouts_in_workout_rv);
        createWorkoutRV.hasFixedSize();
        createWorkoutRV.setLayoutManager(new LinearLayoutManager(getContext()));

        createWorkoutRVAdapter = new CreateWorkoutRVAdapter();
        createWorkoutRV.setAdapter(createWorkoutRVAdapter);

        mViewModel.getAllSavedExercisesForWorkout(i).observe(getViewLifecycleOwner(), new Observer<List<SimpleExercise>>() {
            @Override
            public void onChanged(List<SimpleExercise> exercises) {
                createWorkoutRVAdapter.setDataSet((ArrayList<SimpleExercise>) exercises);
                createWorkoutRV.setAdapter(createWorkoutRVAdapter);
            }
        });

        return root;


    }
}
