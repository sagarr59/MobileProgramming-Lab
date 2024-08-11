package com.example.spinnerapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Spinner by its ID
        Spinner spinner = findViewById(R.id.my_spinner);

        // Get the string array from resources
        String[] options = getResources().getStringArray(R.array.my_string_array);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);



        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}
