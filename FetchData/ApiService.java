package com.example.fetchdata;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("student.php") // Change this to your actual endpoint
    Call<Void> insertStudent(@Body Student student);
}