package com.example.fitnessapp.UI.home.rv;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.models.wgerAPI.exerciseInfo.Result;

import java.util.ArrayList;

public class WorkoutRVAdapter extends RecyclerView.Adapter<WorkoutRVAdapter.ViewHolder> {

    private ArrayList<Result> exercisesArrayList;

    public WorkoutRVAdapter() {
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

    }

    @Override
    public int getItemCount() {
        return exercisesArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
