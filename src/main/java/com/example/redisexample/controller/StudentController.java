package com.example.redisexample.controller;

import java.util.ArrayList;

import com.example.redisexample.model.Student;
import com.example.redisexample.service.student.StudentService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController{
    private StudentService studentService;

    public StudentController(@Qualifier("StudentServiceImpl") StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value="/all")
    public ResponseEntity<Object> getAllStudent(){
        ArrayList<Student> studentList = studentService.getAllStudent();
        return new ResponseEntity<Object>(studentList, HttpStatus.OK);
    }

    @GetMapping(value="/create")
    public ResponseEntity<String> createStudent(){
        studentService.createStudent();
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}