package com.example.fitnessapp.UI.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.createWorkout.CreateWorkoutFragment;
import com.example.fitnessapp.UI.home.rv.WorkoutRVAdapter;
import com.example.fitnessapp.models.Workout;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView workoutRV;
    private WorkoutRVAdapter workoutRVAdapter;
    private List<Workout> savedWorkouts;
    private FloatingActionButton addItem;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
            View root = inflater.inflate(R.layout.fragment_home, container, false);

            addItem = root.findViewById(R.id.add_item);


            workoutRV = root.findViewById(R.id.workoutListRV);
            workoutRV.hasFixedSize();
            workoutRV.setLayoutManager(new LinearLayoutManager(getContext()));

            workoutRVAdapter = new WorkoutRVAdapter();
            workoutRV.setAdapter(workoutRVAdapter);

            mViewModel.getExerciseAsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Result>>() {
                @Override
                public void onChanged(List<Result> exercises) {
                    workoutRVAdapter.setDataSet((ArrayList<Result>) exercises);
                    workoutRV.setAdapter(workoutRVAdapter);
                }
            });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.HomeFragment, new CreateWorkoutFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

            return root;

    }



}