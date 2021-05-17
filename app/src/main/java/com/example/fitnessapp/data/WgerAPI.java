package com.example.fitnessapp.data;

import com.example.fitnessapp.models.wgerAPI.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WgerAPI {

    @GET("api/v2/exerciseinfo/?name={name}")
    Call<Root> getExercise(@Path("name") String name);
}
