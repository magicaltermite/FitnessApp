package com.example.fitnessapp.data;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Root;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkoutDAO {

    private static WorkoutDAO instance;
    private final MutableLiveData<List<Result>> exerciseList;

    private WorkoutDAO() {
        exerciseList = new MutableLiveData<>();
    }

    public static WorkoutDAO getInstance() {
        if (instance == null)
            instance = new WorkoutDAO();
        return instance;
    }



    public LiveData<List<Result>> getExercisesAsLiveData() {
        return exerciseList;
    }

    public void getAllExercises() {
        WgerAPI wgerAPI = ServiceGenerator.getWgerApi();

        Call<Root> call = wgerAPI.getExercises();
        call.enqueue(new Callback<Root>() {

            @Override
            public void onResponse(@NotNull Call<Root> call, @NotNull Response<Root> response) {
                if (response.code() == 200) {
                    exerciseList.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Root> call, @NotNull Throwable t) {
                Log.i("retrofit, WorkoutDAO", "Something went wrong: (");
            }
        });


    }

    public String getExercise() {
        List<Result> results = exerciseList.getValue();

        return "results.get(0).getName();";
    }




}
