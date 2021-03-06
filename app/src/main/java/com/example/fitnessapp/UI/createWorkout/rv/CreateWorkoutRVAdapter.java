package com.example.fitnessapp.UI.createWorkout.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.UI.home.rv.WorkoutRVAdapter;
import com.example.fitnessapp.models.SimpleExercise;
import com.example.fitnessapp.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkoutRVAdapter extends RecyclerView.Adapter<CreateWorkoutRVAdapter.ViewHolder> {

    private List<SimpleExercise> exerciseList;

    public CreateWorkoutRVAdapter() {
        exerciseList = new ArrayList<>();
    }

    public void setDataSet(ArrayList<SimpleExercise> exerciseArrayList) {
        this.exerciseList = exerciseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_exercise, parent, false);
        return new CreateWorkoutRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleExercise exercise = exerciseList.get(position);
        exercise.setName(holder.workoutName.getText().toString());


    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        EditText workoutName, workoutMuscle;
        Button addExerciseButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            workoutName = itemView.findViewById(R.id.workoutName);

            addExerciseButton = itemView.findViewById(R.id.add_exercise_button);
        }
    }
}
