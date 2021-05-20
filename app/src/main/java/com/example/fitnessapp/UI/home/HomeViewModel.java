package com.example.fitnessapp.UI.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitnessapp.data.WorkoutRepository;
import com.example.fitnessapp.models.Workout;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private WorkoutRepository workoutRepository;
    private Context context;

    public HomeViewModel() {
        workoutRepository = WorkoutRepository.getInstance();
    }

    public LiveData<List<Result>> getExerciseAsLiveData() {
        return workoutRepository.getExercisesAsLiveData();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Workout> getAllSavedWorkouts(Context context) {
        return workoutRepository.getSavedWorkouts(context);
    }






}