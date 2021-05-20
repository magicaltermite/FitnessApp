package com.example.fitnessapp.models;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Category;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Comment;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Equipment;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Image;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Language;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.License;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Muscle;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.MusclesSecondary;

import java.util.List;

public class SimpleWorkout {

    public String name;
    public String description;
    public List<Muscle> muscles;
    public List<Equipment> equipment;

    public SimpleWorkout(String name, String description, List<Muscle> muscles, List<MusclesSecondary> muscles_secondary, List<Equipment> equipment) {
        this.name = name;
        this.description = description;
        this.muscles = muscles;

        this.equipment = equipment;
    }


    //region getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }



    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
    //endregion
}
