package com.example.fitnessapp.data;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fitnessapp.models.SimpleExercise;
import com.example.fitnessapp.models.Workout;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Root;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkoutDAO {

    private static WorkoutDAO instance;
    private final MutableLiveData<List<Result>> exerciseList;
    private MutableLiveData<List<SimpleExercise>> exercisesForWorkoutList;
    private List<Workout> workoutsList;

    private WorkoutDAO() {
        exerciseList = new MutableLiveData<>();
        exercisesForWorkoutList = new MutableLiveData<>();
        workoutsList = new ArrayList<>();
    }

    public static WorkoutDAO getInstance() {
        if (instance == null)
            instance = new WorkoutDAO();
        return instance;
    }



    public LiveData<List<Result>> getExercisesAsLiveData() {
        return exerciseList;
    }

    public void getAllExercisesFromAPI() {
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



    public List<Workout> getAllSavedWorkouts(Context context) {
        String fileInfo = null;
        try {
            FileInputStream fis = context.openFileInput("workoutSaveFiles.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while ((fileInfo = bufferedReader.readLine()) != null) {
                sb.append(fileInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Workout>>() {}.getType();

        workoutsList = gson.fromJson(fileInfo, listType);

        return workoutsList;
    }


    public void saveWorkoutsToInternal(Context mcoContext, String sFileName, String sBody) {
        File savedWorkoutsDir = new File(mcoContext.getFilesDir(), "workoutDir");

        if(!savedWorkoutsDir.exists()) {
            savedWorkoutsDir.mkdir();
        }

        try {
            File gpxFile = new File(savedWorkoutsDir, sFileName);
            FileWriter writer = new FileWriter(gpxFile);
            writer.append(sBody);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LiveData<List<SimpleExercise>> getAllSavedExercises(int i) {
        exercisesForWorkoutList.setValue(workoutsList.get(i).getExercises());
        return exercisesForWorkoutList;
    }




}
