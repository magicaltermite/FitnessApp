package com.example.fitnessapp.data;

import androidx.lifecycle.LiveData;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class WorkoutRepository {
    private static WorkoutRepository instance;
    private WorkoutDAO workoutDAO;

    private WorkoutRepository() {
        workoutDAO = WorkoutDAO.getInstance();
    }

    public static WorkoutRepository getInstance() {
        if (instance == null)
            instance = new WorkoutRepository();
        return instance;
    }


    public LiveData<List<Result>> getExercisesAsLiveData() {
        return workoutDAO.getExercisesAsLiveData();
    }


    public void getAllExercises() {
        workoutDAO.getAllExercisesFromAPI();
    }

    public String getExercise() {
        return workoutDAO.getExercise();
    }


}
