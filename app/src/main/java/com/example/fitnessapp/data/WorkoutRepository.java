package com.example.fitnessapp.data;

import androidx.lifecycle.LiveData;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.ArrayList;
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

    public ArrayList<Result> getExercises() {
        return null;
    }

    public LiveData<List<Result>> getExercisesAsLiveData() {
        return workoutDAO.getSearchExerciseAsLiveData();
    }


    public void searchExercise(String name) {
        workoutDAO.searchForExercise(name);
    }


}
