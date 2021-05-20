package com.example.fitnessapp.models;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Muscle;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    String name;
    ArrayList<SimpleExercise> exercises;

    public Workout(String name, ArrayList<SimpleExercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercises(ArrayList<SimpleExercise> exercises) {
        this.exercises = exercises;
    }

    public List<SimpleExercise> getExercises() {
        return exercises;
    }



}
