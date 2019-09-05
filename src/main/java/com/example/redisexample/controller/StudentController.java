package com.example.redisexample.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import com.example.redisexample.model.Student;
import com.example.redisexample.service.student.StudentService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping(value = "/all/cached")
    public ResponseEntity<Map<Object, Student>> getAllCachedStudent(){
        Map<Object, Student> mapCachedStudent = studentService.getAllCachedStudent();
        return new ResponseEntity<Map<Object, Student>>(mapCachedStudent, HttpStatus.OK);
    }

}