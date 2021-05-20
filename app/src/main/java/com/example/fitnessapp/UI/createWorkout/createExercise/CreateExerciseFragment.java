package com.example.fitnessapp.UI.createWorkout.createExercise;

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
import androidx.lifecycle.ViewModelProvider;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.createWorkout.CreateWorkoutFragment;
import com.example.fitnessapp.UI.createWorkout.CreateWorkoutViewModel;
import com.example.fitnessapp.models.SimpleExercise;

public class CreateExerciseFragment extends Fragment implements Parcelable {

    private CreateExerciseViewModel mViewModel;
    private SimpleExercise exercise;
    private EditText exerciseName, exerciseDescription;
    private Button addExerciseToWorkoutButton;

    protected CreateExerciseFragment(Parcel in) {
    }

    public CreateExerciseFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CreateExerciseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_exercise, container, false);



        exerciseName = root.findViewById(R.id.exerciseName);
        exerciseDescription = root.findViewById(R.id.exerciseDescription);
        addExerciseToWorkoutButton = root.findViewById(R.id.add_exercise_to_workout_button);

        exercise = new SimpleExercise(exerciseName.getText().toString(),
                exerciseDescription.getText().toString());

        addExerciseToWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CreateWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("Exercise", exercise);
                fragment.setArguments(bundle);

                CreateWorkoutFragment createWorkoutFragment = new CreateWorkoutFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, createWorkoutFragment).addToBackStack("tag").commit();
            }
        });

        return root;
    }




    public static final Creator<CreateExerciseFragment> CREATOR = new Creator<CreateExerciseFragment>() {
        @Override
        public CreateExerciseFragment createFromParcel(Parcel in) {
            return new CreateExerciseFragment(in);
        }

        @Override
        public CreateExerciseFragment[] newArray(int size) {
            return new CreateExerciseFragment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
