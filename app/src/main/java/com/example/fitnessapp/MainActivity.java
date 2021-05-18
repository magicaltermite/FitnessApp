package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessapp.UI.createWorkoutPlan.CreateWorkoutPlanFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.jumpToFragment);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;

        switch (view.getId()) {
            case R.id.jumpToFragment:
                fragment = CreateWorkoutPlanFragment.newInstance();
                replaceFragment(fragment);
                break;
        }
    }



    public void replaceFragment(Fragment replacementFragment) {

    }
}