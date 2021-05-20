package com.example.fitnessapp.models;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Muscle;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    String name;
    ArrayList<Muscle> muscles;
    ArrayList<SimpleExercise> exercises;

    public Workout(String name, ArrayList<Muscle> muscles, ArrayList<SimpleExercise> exercises) {
        this.name = name;
        this.muscles = muscles;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(ArrayList<Muscle> muscles) {
        this.muscles = muscles;
    }

    public void setExercises(ArrayList<SimpleExercise> exercises) {
        this.exercises = exercises;
    }

    public List<SimpleExercise> getExercises() {
        return exercises;
    }



}
