package com.example.fitnessapp.UI.home.rv;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRVAdapter extends RecyclerView.Adapter<WorkoutRVAdapter.ViewHolder> {

    private List<Result> exercisesArrayList;

    public WorkoutRVAdapter() {
        exercisesArrayList = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Result> exercisesArrayList) {
        this.exercisesArrayList = exercisesArrayList;
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
        Result exercise = exercisesArrayList.get(position);
        holder.exerciseName.setText(exercise.getName());
        holder.exerciseDescription.setText(exercise.getDescription());


    }

    @Override
    public int getItemCount() {
        return exercisesArrayList.size();

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView exerciseName, exerciseDescription, muscle1, muscle2;

        ViewHolder(View itemView) {
            super(itemView);

            exerciseName = itemView.findViewById(R.id.exerciseName);
            exerciseDescription = itemView.findViewById(R.id.exerciseDescription);
            muscle1 = itemView.findViewById(R.id.muscle1);
            muscle2 = itemView.findViewById(R.id.muscle2);
        }
    }

}
