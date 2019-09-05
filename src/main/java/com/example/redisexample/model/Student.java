package com.example.redisexample.model;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "student")
public class Student extends JdkSerializationRedisSerializer implements Serializable {
    private static final long serialVersionUID = 1L;

    public Student(){

    }

    public Student(String name, String gender, int grade){
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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