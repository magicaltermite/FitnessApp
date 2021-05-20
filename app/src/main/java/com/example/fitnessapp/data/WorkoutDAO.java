package com.example.fitnessapp.data;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Root;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WorkoutDAO {

    private static WorkoutDAO instance;
    private final MutableLiveData<List<Result>> searchExercise;
    private List<Result> exercisesList;

    private WorkoutDAO() {
        searchExercise = new MutableLiveData<>();
        exercisesList = new ArrayList<>();
    }

    public static WorkoutDAO getInstance() {
        if (instance == null)
            instance = new WorkoutDAO();
        return instance;
    }

    public ArrayList<Result> getExercises() {
        exercisesList.addAll((Collection<? extends Result>) searchExercise);
        return null;
    }

    public LiveData<List<Result>> getSearchExerciseAsLiveData() {
        return searchExercise;
    }

    public void searchForExercise(String name) {
        WgerAPI wgerAPI = ServiceGenerator.getWgerApi();

        Call<Root> call = wgerAPI.getExercise(name);
        call.enqueue(new Callback<Root>() {

            @Override
            public void onResponse(@NotNull Call<Root> call, @NotNull Response<Root> response) {
                if (response.code() == 200) {
                    searchExercise.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Root> call, @NotNull Throwable t) {
                Log.i("retrofit, WorkoutDAO", "Something went wrong: (");
            }
        });


    }




}
