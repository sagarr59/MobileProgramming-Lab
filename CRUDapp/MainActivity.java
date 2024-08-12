package com.example.crudapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText idET, nameET;
    private TextView resultTV;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idET = findViewById(R.id.editTextId);
        nameET = findViewById(R.id.editTextName);
        resultTV = findViewById(R.id.textViewResult);

        db = new DBHelper(this);

        findViewById(R.id.buttonInsert).setOnClickListener(v -> {
            db.insert(Integer.parseInt(idET.getText().toString()), nameET.getText().toString());
            resultTV.setText("Inserted");
        });

        findViewById(R.id.buttonUpdate).setOnClickListener(v -> {
            db.update(Integer.parseInt(idET.getText().toString()), nameET.getText().toString());
            resultTV.setText("Updated");
        });

        findViewById(R.id.buttonDelete).setOnClickListener(v -> {
            db.delete(Integer.parseInt(idET.getText().toString()));
            resultTV.setText("Deleted");
        });

        findViewById(R.id.buttonRead).setOnClickListener(v -> {
            Cursor cursor = db.read();
            StringBuilder sb = new StringBuilder();
            while (cursor.moveToNext()) {
                sb.append("ID: ").append(cursor.getInt(0)).append(", Name: ").append(cursor.getString(1)).append("\n");
            }
            resultTV.setText(sb.toString());
            cursor.close();
        });
    }
}
