package com.example.fitnessapp.UI.home.rv;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRVAdapter extends RecyclerView.Adapter<WorkoutRVAdapter.ViewHolder> {

    private List<Workout> workoutsList;

    public WorkoutRVAdapter() {
        workoutsList = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Workout> exercisesArrayList) {
        this.workoutsList = exercisesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_workout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workout workout = workoutsList.get(position);
        holder.dayOfWeek.setText(workout.getName());

    }

    @Override
    public int getItemCount() {
        return workoutsList.size();

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayOfWeek, muscleGroup, numOfExercises;

        ViewHolder(View itemView) {
            super(itemView);

            dayOfWeek = itemView.findViewById(R.id.day);
            muscleGroup = itemView.findViewById(R.id.muscleGroup);
            numOfExercises = itemView.findViewById(R.id.numOfExercises);
        }
    }

}
