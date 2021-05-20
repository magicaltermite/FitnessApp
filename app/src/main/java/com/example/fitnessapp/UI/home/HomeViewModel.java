package com.example.fitnessapp.UI.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitnessapp.data.WorkoutRepository;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private WorkoutRepository workoutRepository;

    public HomeViewModel() {
        workoutRepository = WorkoutRepository.getInstance();
    }

    public LiveData<List<Result>> getExerciseAsLiveData() {
        return workoutRepository.getExercisesAsLiveData();
    }

    public void searchExercise(String name) {
        workoutRepository.searchExercise(name);
    }


}