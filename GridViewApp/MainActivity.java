package com.example.gridviewapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 6","Item 7", "Item 8", "Item 9");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.grid_item, R.id.textViewItem, items);
        gridView.setAdapter(adapter);
    }
}
