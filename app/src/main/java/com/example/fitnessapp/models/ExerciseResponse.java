package com.example.fitnessapp.models;

import com.example.fitnessapp.models.wgerAPI.Muscle;
import com.example.fitnessapp.models.wgerAPI.MusclesSecondary;
import com.example.fitnessapp.models.wgerAPI.Result;
import com.example.fitnessapp.models.wgerAPI.Root;

import java.util.List;

public class ExerciseResponse {

    public int id;
    public String name;
    public String description;
    public List<Muscle> muscles;
    public List<MusclesSecondary> muscles_secondary;

    public ExerciseResponse(int id, String name, String description, List<Muscle> muscles, List<MusclesSecondary> muscles_secondary) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.muscles = muscles;
        this.muscles_secondary = muscles_secondary;
    }
}
