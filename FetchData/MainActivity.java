package com.example.fetchdata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sending_data_to_remote_server.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://10.0.2.2:80"; // Localhost in the emulator


    private EditText nameEditText, emailEditText, phoneEditText;
    private Button submitButton;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        submitButton = findViewById(R.id.submitButton);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the student list and adapter
        studentList = new ArrayList<>();
        studentAdapter = new StudentAdapter(studentList);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

        // Set up Retrofit
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudent(apiService);
            }
        });
    }

    private void insertStudent(ApiService apiService) {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();

        Student student = new Student(name, email, phone);

        Call<Void> call = apiService.insertStudent(student);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    studentList.add(student); // Add the new student to the list

                } else {
                    Toast.makeText(MainActivity.this, "Failed to insert student", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("API Call", "Failed", t);
                Toast.makeText(MainActivity.this, "Failed to insert student", Toast.LENGTH_SHORT).show();
            }
        });
    }
}