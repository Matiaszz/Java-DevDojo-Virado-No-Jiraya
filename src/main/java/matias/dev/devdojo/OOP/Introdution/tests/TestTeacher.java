package matias.dev.devdojo.OOP.Introdution.tests;


import matias.dev.devdojo.OOP.Introdution.domain.Teacher;

public class TestTeacher {


    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        double[] salaries = {20, 225.37, 92, 230, 111};

        teacher.setSalary(salaries);
        teacher.setName("John");
        teacher.setAge(18);

        System.out.println(teacher.mediaSalary());

        teacher.printData();
    }
}
