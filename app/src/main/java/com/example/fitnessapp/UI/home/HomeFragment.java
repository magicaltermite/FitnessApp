package com.example.fitnessapp.UI.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView workoutRV;
    private WorkoutRVAdapter workoutRVAdapter;
    private ArrayList<Workout> savedWorkouts;
    private FloatingActionButton addItem;
    private SharedPreferences preferences;
    private String saveData;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        addItem = root.findViewById(R.id.add_item);
        saveData = "";
        savedWorkouts = new ArrayList<>();

        preferences = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);

        saveData = preferences.getString("saveData", "default value");

        Gson gson = new Gson();
        //Type listType = new TypeToken<List<Workout>>() {}.getType();
        //savedWorkouts = gson.fromJson(saveData, listType);

        Workout workout = gson.fromJson(saveData, Workout.class);

        workoutRV = root.findViewById(R.id.workoutListRV);
        workoutRV.hasFixedSize();
        workoutRV.setLayoutManager(new LinearLayoutManager(getContext()));

        workoutRVAdapter = new WorkoutRVAdapter();
        workoutRVAdapter.setDataSet(savedWorkouts);
        workoutRV.setAdapter(workoutRVAdapter);



        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateWorkoutFragment fragment = new CreateWorkoutFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack("tag").commit();
            }
        });

            return root;

    }



}