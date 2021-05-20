package com.example.fitnessapp.UI.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import android.widget.Button;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.home.rv.WorkoutRVAdapter;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView workoutRV;
    private WorkoutRVAdapter workoutRVAdapter;

    private Button button;
    ArrayList<Result> exercises;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
            View root = inflater.inflate(R.layout.fragment_home, container, false);

            button = root.findViewById(R.id.sendToDiet);


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

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    System.out.println("Before Transaction: Button in HomeFragment pressed");
                    FragmentTransaction fragmentTransaction = getActivity()
                            .getSupportFragmentManager().beginTransaction();
                    HomeFragment fragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.commit();
                    System.out.println("After Transaction: Button in HomeFragment pressed");
                }
            });

            return root;

    }



}