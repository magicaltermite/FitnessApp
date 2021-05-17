package com.example.fitnessapp.models.wgerAPI.exerciseInfo;

import java.util.List;

public class Root {
    public int count;
    public String next;
    public Object previous;
    public List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Root{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous=" + previous +
                ", results=" + results +
                '}';
    }
}
