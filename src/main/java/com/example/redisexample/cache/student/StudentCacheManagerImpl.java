package com.example.redisexample.cache.student;

import com.example.redisexample.config.RedisUtil;
import com.example.redisexample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
public class StudentCacheManagerImpl implements StudentCacheManager {
    public static final String TABLE_STUDENT = "TABLE_STUDENT";
    public static final String STUDENT = "STUDENT_";
    private RedisUtil<Student> redisUtilStudent;

    @Autowired
    public StudentCacheManagerImpl(RedisUtil<Student> redisUtilStudent) {
        this.redisUtilStudent = redisUtilStudent;
    }

    @Override
    public void cacheStudentDetails(Student student) {
        redisUtilStudent.putMap(TABLE_STUDENT,STUDENT +student.getId(),student);
        redisUtilStudent.setExpire(TABLE_STUDENT,1, TimeUnit.DAYS);
    }

    @Override
    public Boolean checkEmpty(Student student) {
        Student cachedStudent = redisUtilStudent.getValue(STUDENT+student.getId());
        Boolean flag = cachedStudent != null ? true : false;
        return flag;
    }

    @Override
    public Map<Object, Student> getAllStudentFromCache() {
        Map<Object, Student> map = redisUtilStudent.getMapAsAll(TABLE_STUDENT);
        return map;
    }

    @Override
    public Student getStudentFromCached(int id) {
        Object student = redisUtilStudent.getMapAsSingleEntry(TABLE_STUDENT, STUDENT+id);
//        for(Method method : student.getClass().getDeclaredMethods()){
//            if (Modifier.isPublic(method.getModifiers())
//                    && method.getParameterTypes().length == 0
//                    && method.getReturnType() != void.class
//                    && (method.getName().startsWith("get") || method.getName().startsWith("is"))
//            ) {
//                Object value = method.invoke(student);
//                if (value != null) {
//                    System.out.println(method.getName() + "=" + value);
//                }
//            }
//        }
        Student temp = (Student)student;
        return temp;
    }


}
