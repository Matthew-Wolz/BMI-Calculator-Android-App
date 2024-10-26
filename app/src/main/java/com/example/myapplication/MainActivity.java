package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private EditText editFeet, editInches, editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI elements
        editFeet = findViewById(R.id.editFeet);
        editInches = findViewById(R.id.editInches);
        editWeight = findViewById(R.id.editWeight);
        Button btnCompute = findViewById(R.id.btnCompute);

        //buttons
        btnCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String feetStr = editFeet.getText().toString();
                String inchesStr = editInches.getText().toString();
                String weightStr = editWeight.getText().toString();

                //checking that our text fields are not empty
                if (!feetStr.isEmpty() && !inchesStr.isEmpty() && !weightStr.isEmpty()){
                    double feet = Double.parseDouble(feetStr);
                    double inches = Double.parseDouble(inchesStr);
                    double weight = Double.parseDouble(weightStr);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("feet", feet);
                    intent.putExtra("inches", inches);
                    intent.putExtra("weight", weight);

                    startActivity(intent);
                }
            }
        });
    }

    //reset text fields
    @Override
    protected void onResume() {
        super.onResume();
        editFeet.setText("");
        editInches.setText("");
        editWeight.setText("");
    }
}
