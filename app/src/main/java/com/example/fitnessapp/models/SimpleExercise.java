package com.example.fitnessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Category;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Comment;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Equipment;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Image;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Language;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.License;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Muscle;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.MusclesSecondary;

import java.util.List;

public class SimpleExercise implements Parcelable {

    public String name;
    public String description;


    public SimpleExercise(String name, String description) {
        this.name = name;
        this.description = description;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }


    //endregion
}
