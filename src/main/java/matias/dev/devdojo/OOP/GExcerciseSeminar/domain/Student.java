package matias.dev.devdojo.OOP.GExcerciseSeminar.domain;

import lombok.Data;

import java.util.Scanner;

@Data
public class Student {
    private String name;
    private int age;
    private Seminar seminar;

    public Student (String name, int age){
        this.name = name;
        this.age = age;
    }
    public Student (String name, int age, Seminar seminar){
        this(name, age);
        this.seminar = seminar;
    }

    public Seminar registerStudentInSeminar(Seminar seminar){
        this.setSeminar(seminar);
        this.seminar.getStudents().add(this);
        return this.seminar;
    }
}
