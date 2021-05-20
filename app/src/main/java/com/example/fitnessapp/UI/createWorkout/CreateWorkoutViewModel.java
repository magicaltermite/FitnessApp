package com.example.fitnessapp.UI.createWorkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitnessapp.data.WorkoutRepository;
import com.example.fitnessapp.models.SimpleExercise;

import java.util.List;

public class CreateWorkoutViewModel extends ViewModel {

    private WorkoutRepository workoutRepository;

    public CreateWorkoutViewModel() {
        workoutRepository = WorkoutRepository.getInstance();
    }

    public LiveData<List<SimpleExercise>> getAllSavedExercisesForWorkout(int i) {
        return workoutRepository.getAllExercises(i);
    }

}
