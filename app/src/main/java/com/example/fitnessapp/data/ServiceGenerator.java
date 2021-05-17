package com.example.fitnessapp.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://wger.de/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static WgerAPI wgerAPI = retrofit.create(WgerAPI.class);

    public static WgerAPI getWgerApi() {
        return wgerAPI;
    }

}
