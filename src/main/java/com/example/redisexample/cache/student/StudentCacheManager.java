package com.example.redisexample.cache.student;

import com.example.redisexample.model.Student;

//import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface StudentCacheManager {
    void cacheStudentDetails(Student student);
    Boolean checkEmpty(Student student);
    Map<Object, Student> getAllStudentFromCache();
    Student getStudentFromCached(int id);
}
