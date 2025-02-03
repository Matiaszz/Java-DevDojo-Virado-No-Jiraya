package dev.matias.devdojo.introdution;

public class Lesson22TernaryOperators {
    public static void main(String[] args){
        double salary = 50;
        String donate = "I'll donate to DevDojo";
        String poor = "I will not donate to DevDojo";
        String result = salary >= 500 ? donate : poor;
        System.out.println(result);
    }


}
