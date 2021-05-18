package com.example.fitnessapp.UI.createWorkoutPlan;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class CreateWorkoutPlanFragment extends Fragment {

    private CreateWorkoutPlanViewModel mViewModel;
    private TextView textView;

    public static CreateWorkoutPlanFragment newInstance() {
        return new CreateWorkoutPlanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        textView = requireView().findViewById(R.id.APITextView);
        textView.setText(mViewModel.getExercise().toString());

        return inflater.inflate(R.layout.create_workout_plan_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateWorkoutPlanViewModel.class);
        // TODO: Use the ViewModel
    }

}