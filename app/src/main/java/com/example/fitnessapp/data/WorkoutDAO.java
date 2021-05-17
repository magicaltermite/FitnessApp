package com.example.fitnessapp.data;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WorkoutDAO {

    private static WorkoutDAO instance;
    private final MutableLiveData<List<Result>> searchExercise;

    public WorkoutDAO() {
        searchExercise = new MutableLiveData<>();
    }

    public static WorkoutDAO getInstance() {
        if (instance == null)
            instance = new WorkoutDAO();
        return instance;
    }

    public LiveData<List<Result>> getSearchExercise() {
        return searchExercise;
    }

    public void searchForExercise(String name) {
        WgerAPI wgerAPI = ServiceGenerator.getWgerApi();

        Call<Root> call = wgerAPI.getExercise(name);
        call.enqueue(new Callback<Root>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    searchExercise.setValue(response.body().getResult());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.i("retrofit, WorkoutDAO", "Something went wrong: (");
            }
        });


    }




}
