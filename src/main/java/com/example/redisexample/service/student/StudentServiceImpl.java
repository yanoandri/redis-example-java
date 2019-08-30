package com.example.redisexample.service.student;

import java.util.ArrayList;

import com.example.redisexample.model.Student;
import com.example.redisexample.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList = (ArrayList<Student>)studentRepository.findAll();
        return studentList;
    }

    @Override
	public void createStudent() {
		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
	}

    
}