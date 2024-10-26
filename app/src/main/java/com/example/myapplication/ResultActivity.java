package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // UI elements
        TextView txtBMIResult = findViewById(R.id.txtBMIResult);
        TextView txtSuggestion = findViewById(R.id.txtSuggestion);
        Button btnBack = findViewById(R.id.btnBack);

        // Retrieve data from intent
        Intent intent = getIntent();
        double feet = intent.getDoubleExtra("feet", 0);
        double inches = intent.getDoubleExtra("inches", 0);
        double weight = intent.getDoubleExtra("weight", 0);

        // Calculate BMI
        double heightInInches = (feet * 12) + inches;
        double bmi = (weight / (heightInInches * heightInInches)) * 703;

        // Determine BMI suggestion
        String suggestion;
        if (bmi < 18.5) {
            suggestion = "You are too slim! You need more sandwich!";
        } else if (bmi < 24.9) {
            suggestion = "Your body is in good shape!";
        } else if (bmi < 29.9) {
            suggestion = "Watch out! You are slightly overweight!";
        } else {
            suggestion = "You need to lose a couple of pounds!";
        }

        // Display BMI and suggestion
        txtBMIResult.setText("Your BMI: " + String.format("%.2f", bmi));
        txtSuggestion.setText(suggestion);

        // Back button listener
        btnBack.setOnClickListener(view -> finish());
    }
}
