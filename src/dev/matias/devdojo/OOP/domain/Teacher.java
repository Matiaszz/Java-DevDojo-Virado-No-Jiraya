package dev.matias.devdojo.OOP.domain;

import java.util.Arrays;

public class Teacher {
    private String name;
    private int age;
    private double[] salaries;


    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public double[] getSalaries(){
        return salaries;
    }
    public void setAge(int value){
        age = value;
    }
    public void setName(String value){
        name = value;
    }
    public void setSalary(double[] value){
        salaries = value;
    }

    public void printData(){

        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salaries:");

        for (double salary : getSalaries()){
            System.out.println(salary);
        }
    }
    public double mediaSalary(){
        return Arrays.stream(salaries).average().orElse(0);
    }
}
