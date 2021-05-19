package com.example.fitnessapp.UI.createWorkoutPlan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitnessapp.data.WorkoutRepository;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class CreateWorkoutPlanViewModel extends ViewModel {

    private WorkoutRepository workoutRepository;

    public CreateWorkoutPlanViewModel() {
        workoutRepository = WorkoutRepository.getInstance();
    }

    public LiveData<List<Result>> getExerciseAsLiveData() {
        return workoutRepository.getExercise();
    }

    public void searchExercise(String name) {
        workoutRepository.searchExercise(name);
    }


}