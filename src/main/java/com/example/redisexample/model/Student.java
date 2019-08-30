package com.example.redisexample.model;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
public class Student implements Serializable {
   
    private static final long serialVersionUID = 1L;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String id, String name, Gender gender, int grade){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }
 
    private String id;
    private String name;
    private Gender gender;
    private int grade;

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}