package com.example.fitnessapp.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.fitnessapp.models.MyApplication;
import com.example.fitnessapp.models.SimpleExercise;
import com.example.fitnessapp.models.Workout;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.List;

public class WorkoutRepository {
    private static WorkoutRepository instance;
    private WorkoutDAO workoutDAO;
    private Context context;

    private WorkoutRepository() {
        context = MyApplication.getAppContext();
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


    public LiveData<List<SimpleExercise>> getAllExercises(int i) {
        return workoutDAO.getAllSavedExercises(context, i);
    }

    public List<Workout> getSavedWorkouts() {
        return workoutDAO.getAllSavedWorkouts(context);
    }

}
