package com.example.fitnessapp.models.wgerAPI.exerciseInfo;

import java.util.List;

public class Result {
    public int id;
    public String name;
    public String uuid;
    public String description;
    public String creation_date;
    public Category category;
    public List<Muscle> muscles;
    public List<MusclesSecondary> muscles_secondary;
    public List<Equipment> equipment;
    public Language language;
    public License license;
    public String license_author;
    public List<Image> images;
    public List<Comment> comments;
    public List<Integer> variations;


}
