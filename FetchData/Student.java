package com.example.fetchdata;

public class Student {
    private String name;
    private String email;
    private String phone;

    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPhone(){
        return phone;
    }

    // Getters and setters
}