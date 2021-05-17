package com.example.fitnessapp.models.wgerAPI.exerciseInfo;

import java.util.List;

public class Root {
    public int count;
    public String next;
    public Object previous;
    public List<Result> results;

    public List<Result> getResult() {
        return results;
    }
}
