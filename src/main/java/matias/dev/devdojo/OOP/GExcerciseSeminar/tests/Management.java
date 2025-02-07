package matias.dev.devdojo.OOP.GExcerciseSeminar.tests;

import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Local;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Seminar;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Student;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Teacher;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Management {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teacher marliTeacher = new Teacher("Marli", "IT");
        Teacher geraldoTeacher = new Teacher("Geraldo", "Physics");
        List<Teacher> teachers = new ArrayList<>();

        Local local = new Local("Address local 1");
        Seminar moduleOfCourse = new Seminar("Module of a course", local);
        geraldoTeacher.registerSeminarInOwnedSeminars(moduleOfCourse, local);

        teachers.add(marliTeacher);
        teachers.add(geraldoTeacher);

        String[] options = {"1. Register student in Seminar", "5. Exit"};
        while (true) {
            System.out.println("\n".repeat(25));

            System.out.println("What you wanna do?");
            for (String option : options) {
                System.out.println(option);
            }

            String choice = input.nextLine().trim();
            if (choice.isEmpty()) continue;

            char option = choice.charAt(0);
            if (option == '1') {
                Teacher teacher = loginTeacher(teachers, input);
                if (teacher != null) {
                    registerStudentInSeminar(teacher, input);
                } else {
                    System.out.println("Teacher not found, try again.");
                }
            } else if (option == '5') {
                System.out.println("Finishing");
                break;
            } else {
                System.out.println("This option doesn't exist");
            }
        }
    }

    public static void registerStudentInSeminar(@NotNull Teacher teacher, @NotNull Scanner input) {
        List<Seminar> seminars = teacher.getSeminars();
        if (seminars.isEmpty()) {
            System.out.println("No seminars available for this teacher.");
            return;
        }

        System.out.println("Type the student name:");
        String name = input.nextLine();

        System.out.println("Type the student age:");
        int age;
        try {
            age = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("Age field should be an 'Integer' Type");
            input.nextLine();
            return;
        }

        System.out.println("Seminars:");
        for (int k = 0; k < seminars.size(); k++) {
            System.out.println(k + " " + seminars.get(k));
        }

        System.out.println("Type the title of the Seminar where you want to register the student:");
        String seminarResponse = input.nextLine().trim();

        Seminar seminar = seminars.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(seminarResponse))
                .findFirst()
                .orElse(null);

        if (seminar == null) {
            System.out.println("Seminar doesn't exist.");
            return;
        }

        Student student = new Student(name, age, seminar);
        seminar.getStudents().add(student);

        System.out.println("Student '" + student.getName() + "' added into '" + seminar.getTitle() + "' successfully");
    }

    public static Teacher loginTeacher(@NotNull List<Teacher> teachers, @NotNull Scanner input) {
        System.out.println("What teacher are you?");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + " " + teachers.get(i));
        }

        System.out.println("Type the name of the teacher:");
        String teacherResponse = input.nextLine().trim();

        Teacher teacher = teachers.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teacherResponse))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Teacher doesn't exist.");
            return null;
        }

        System.out.println("Teacher: " + teacher);
        return teacher;
    }
}
