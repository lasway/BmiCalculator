package com.ism.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    @SuppressLint("SetTextI18n")
    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            final EditText heightText = findViewById(R.id.height);
            String heightStr = heightText.getText().toString();
            double height = Double.parseDouble(heightStr);
            double heightM = height/100;
            final EditText weightText = findViewById(R.id.weight);
            String weightStr = weightText.getText().toString();
            double weight = Double.parseDouble(weightStr);
            double BMI = (weight) / (heightM * heightM);
            DecimalFormat df = new DecimalFormat("#.#");
            double BMI_trimmed = Double.parseDouble(df.format(BMI));
            final TextView BMIResult = findViewById(R.id.result);
            BMIResult.setText(Double.toString(BMI_trimmed));
            String BMI_Cat;
            if (BMI < 18.5){
                BMI_Cat = "underweight";
            }
            else if (BMI >= 18.5 && BMI < 24.9){
                BMI_Cat = "Healthy Weight";
            }
            else if (BMI >=25 && BMI < 29.9){
                BMI_Cat = "overweight";
            }
            else if (BMI >=30 && BMI < 34.9){
                BMI_Cat = "obese";
            }
            else if (BMI >= 35 && BMI < 39.9){
                BMI_Cat = "Severely Obese";
            }
            else {
                BMI_Cat = "Morbidly Obese";

            }
            final TextView BMICategory = findViewById(R.id.bmiCat);
            BMICategory.setText(BMI_Cat);
        });
    }
}