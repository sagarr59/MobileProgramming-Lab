package com.example.simplecalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.num1);
        et2 = findViewById(R.id.num2);
        tvRes = findViewById(R.id.res);

        findViewById(R.id.add).setOnClickListener(v -> calc('+'));
        findViewById(R.id.sub).setOnClickListener(v -> calc('-'));
        findViewById(R.id.mul).setOnClickListener(v -> calc('*'));
        findViewById(R.id.div).setOnClickListener(v -> calc('/'));
    }

    private void calc(char op) {
        try {
            double a = Double.parseDouble(et1.getText().toString());
            double b = Double.parseDouble(et2.getText().toString());
            double res = 0;
            String resultText = "";

            switch (op) {
                case '+':
                    res = a + b;
                    resultText = "Sum: " + res;
                    break;
                case '-':
                    res = a - b;
                    resultText = "Difference: " + res;
                    break;
                case '*':
                    res = a * b;
                    resultText = "Product: " + res;
                    break;
                case '/':
                    if (b != 0) {
                        res = a / b;
                        resultText = "Division: " + res;
                    } else {
                        resultText = "Div by 0";
                    }
                    break;
            }
            tvRes.setText(resultText);
        } catch (NumberFormatException e) {
            tvRes.setText("Invalid input");
        }
    }

}
