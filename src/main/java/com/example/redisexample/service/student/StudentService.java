package com.example.redisexample.service.student;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import com.example.redisexample.model.Student;

public interface StudentService {
    ArrayList<Student> getAllStudent();
    void createStudent(Student student);
    Map<Object, Student> getAllCachedStudent();
    void updateStudent(int id, Student student);
}