package com.example.redisexample.service.student;

//import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import com.example.redisexample.cache.student.StudentCacheManager;
import com.example.redisexample.model.Student;
import com.example.redisexample.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCacheManager studentCacheManager;

    @Override
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList = (ArrayList<Student>)studentRepository.findAll();
        return studentList;
    }

    @Override
	public void createStudent(Student student) {
        studentRepository.save(student);
        studentCacheManager.cacheStudentDetails(student);
	}

    @Override
    public Map<Object, Student> getAllCachedStudent() {
        Map<Object, Student> cachedStudent = studentCacheManager.getAllStudentFromCache();
        return cachedStudent;
    }

    @Override
    public void updateStudent(int id, Student student){
        Student existing = studentCacheManager.getStudentFromCached(id);
        if(existing == null){
            String temp = String.valueOf(id);
            existing = studentRepository.findById(temp).get();
        }
        existing.setName(student.getName());
        existing.setGender(student.getGender());
        existing.setGrade(student.getGrade());
        studentRepository.save(existing);
        studentCacheManager.cacheStudentDetails(existing);
    }


}