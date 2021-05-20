package com.example.fitnessapp.UI.createWorkout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.createWorkout.createExercise.CreateExerciseFragment;
import com.example.fitnessapp.UI.createWorkout.rv.CreateWorkoutRVAdapter;
import com.example.fitnessapp.UI.home.HomeFragment;
import com.example.fitnessapp.models.SimpleExercise;
import com.example.fitnessapp.models.Workout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CreateWorkoutFragment extends Fragment implements Parcelable {

    private CreateWorkoutViewModel mViewModel;
    private RecyclerView createWorkoutRV;
    private CreateWorkoutRVAdapter createWorkoutRVAdapter;
    private Button addExerciseButton, addWorkoutButton;
    private ArrayList<Workout> workoutsList;
    private SimpleExercise exercise;
    private EditText workoutName;
    private ArrayList<SimpleExercise> exerciseArrayList;
    private SharedPreferences preferences;
    private int i = 0;

    protected CreateWorkoutFragment(Parcel in) {
        i = in.readInt();
    }

    public CreateWorkoutFragment() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CreateWorkoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_workout, container, false);

        addExerciseButton = root.findViewById(R.id.add_exercise_button);
        addWorkoutButton = root.findViewById(R.id.add_workout_button);
        workoutName = root.findViewById(R.id.workoutName);

        preferences = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);

        createWorkoutRV = root.findViewById(R.id.workouts_in_workout_rv);
        createWorkoutRV.hasFixedSize();
        createWorkoutRV.setLayoutManager(new LinearLayoutManager(getContext()));

        createWorkoutRVAdapter = new CreateWorkoutRVAdapter();
        createWorkoutRV.setAdapter(createWorkoutRVAdapter);

        if (mViewModel.getAllSavedExercisesForWorkout(i) != null) {
            mViewModel.getAllSavedExercisesForWorkout(i).observe(getViewLifecycleOwner(), new Observer<List<SimpleExercise>>() {
                @Override
                public void onChanged(List<SimpleExercise> exercises) {
                    createWorkoutRVAdapter.setDataSet((ArrayList<SimpleExercise>) exercises);
                    createWorkoutRV.setAdapter(createWorkoutRVAdapter);
                }
            });
        }

        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateExerciseFragment fragment = new CreateExerciseFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack("tag").commit();

            }
        });

        Bundle bundle = new Bundle();
        exercise = bundle.getParcelable("Exercise");

        exerciseArrayList = new ArrayList<>();
        exerciseArrayList.add(exercise);

        addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Workout workout = new Workout(workoutName.getText().toString(), exerciseArrayList);
                //workoutsList.add(workout);

                Gson gson = new Gson();

                String saveString = gson.toJson(workoutsList);


                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("saveData", saveString);
                editor.apply();

                HomeFragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack("tag").commit();
            }
        });








        return root;
    }

    public static final Creator<CreateWorkoutFragment> CREATOR = new Creator<CreateWorkoutFragment>() {
        @Override
        public CreateWorkoutFragment createFromParcel(Parcel in) {
            return new CreateWorkoutFragment(in);
        }

        @Override
        public CreateWorkoutFragment[] newArray(int size) {
            return new CreateWorkoutFragment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(i);
    }
}
