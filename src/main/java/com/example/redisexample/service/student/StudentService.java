package com.example.redisexample.service.student;

import java.util.ArrayList;

import com.example.redisexample.model.Student;

public interface StudentService {
    ArrayList<Student> getAllStudent();
    void createStudent();
}