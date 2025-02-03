package dev.matias.devdojo.introdution;

import java.util.Date;

public class Lesson05PrimitiveTypesExercise {


    public static void main(String[] args){
        String name = "Matias";
        String address = "Brazil";
        double salary = 1720.0;
        Date date = new Date();

        String response = "I, %s, living in %s, confirm that i have been received the salary of %.2f on date: %tF";


        System.out.printf(
                response, name, address, salary, date);
    }


}
