package com.example.fitnessapp.data;

import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WgerAPI {

    @GET("api/v2/exerciseinfo/")
    Call<Root> getExercises();
}
