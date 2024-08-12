package com.example.simpleinterestapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCalc);
        btn.setOnClickListener(v -> showDialog());
    }

    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_simple_interest, null);

        EditText pInput = view.findViewById(R.id.etPrincipal);
        EditText rInput = view.findViewById(R.id.etRate);
        EditText tInput = view.findViewById(R.id.etTime);

        new AlertDialog.Builder(this)
                .setTitle("Calculate Interest")
                .setView(view)
                .setPositiveButton("Calculate", (dialog, which) -> {
                    try {
                        double p = Double.parseDouble(pInput.getText().toString());
                        double r = Double.parseDouble(rInput.getText().toString());
                        double t = Double.parseDouble(tInput.getText().toString());

                        double interest = (p * r * t) / 100;
                        Toast.makeText(this, "Interest: " + interest, Toast.LENGTH_LONG).show();
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
