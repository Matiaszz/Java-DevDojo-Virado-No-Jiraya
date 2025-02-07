package matias.dev.devdojo.OOP.GExcerciseSeminar.tests;

import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Local;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Seminar;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Student;
import matias.dev.devdojo.OOP.GExcerciseSeminar.domain.Teacher;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Management {
    private static final List<Local> locals = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();
    private static final List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] options = {"1. Register student in Seminar", "2. Register teacher", "3. Register student", "4. Register seminar", "5. Exit"};
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
                Teacher teacher = chooseTeacher(teachers, input);
                if (teacher != null) {
                    registerStudentInSeminar(teacher, input);
                }

            } else if (option == '5') {
                System.out.println("Finishing");
                break;

            } else {
                System.out.println("This option doesn't exist");
            }
        }
    }

    public static void registerStudent(@NotNull Scanner input){
        System.out.println("Type the student name:");
        String name = input.nextLine().trim();

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

        Student student = new Student(name, age);
        students.add(student);
    }

    public static void registerStudentInSeminar(@NotNull Teacher teacher, @NotNull Scanner input) {
        List<Seminar> seminars = teacher.getSeminars();
        if (seminars.isEmpty()) {
            System.out.println("No seminars available for this teacher. Do you like to create? (Y to accept)");
            String createSeminar = input.nextLine().trim();

            if (!createSeminar.equalsIgnoreCase("Y")){
                System.out.println("So, this operation wont be completed.");
                return;
            }
            Seminar seminar = registerSeminar(input);
            teacher.registerSeminarInOwnedSeminars(seminar);
        }


        if (students.isEmpty()){
            System.out.println("No students, do you like to register a student? (Y to accept):");
            String responseRegisterStudent = input.nextLine().trim();

            if (!responseRegisterStudent.equalsIgnoreCase("Y")){
                System.out.println("So, this operation wont be completed.");
                return;
            }else{
                registerStudent(input);
            }

        }
        // TODO: Make it beautiful;
        System.out.println("Choose the student:");
        for (int j = 0; j < students.size(); j++) {
            System.out.println(j + " " + students.get(j));
        }

        System.out.println("Type the chose id below: ");
        String chosenStudentResponse = input.nextLine().trim();

        if (chosenStudentResponse.isEmpty()){
            System.out.println("No student chose, this operation wont continue...");
            return;
        }
        Student student = students.stream()
                .filter(s -> s.getId().toString().equalsIgnoreCase(chosenStudentResponse))
                .findFirst()
                .orElse(null);

        if (student == null){
            System.out.println("Student not found, finishing operation...");
            return;
        }
        System.out.println("Chosen student:\nID = " + student.getId() + "\nName = " + student.getName());
        System.out.println();

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

        if (seminar.getLocal() == null && locals.isEmpty()){
            System.out.println("This seminar doesn't have a local and have no locals registered, do you like to" +
                    " register a local and associate this created local with '" + seminar.getTitle() + "' seminar's?" +
                    " (Y to accept)");

            String createLocalResponse = input.nextLine().trim();

            if (!createLocalResponse.equalsIgnoreCase("Y")){
                System.out.println("So, this operation wont be completed.");
                return;
            }
            Local local = registerLocal(input);
            if (local == null) return;
            seminar.setLocal(local);
            local.registerSeminarInLocal(seminar);

        }
        if (student.getSeminar() != null){
            System.out.println("This student already have a seminar, do you want to overwrite?: ");
            String overwriteSeminarResponse = input.nextLine().trim();
            if (!overwriteSeminarResponse.equalsIgnoreCase("Y")){
                System.out.println("Finishing operation...");
                return;
            }
        }
        student.setSeminar(seminar);

        seminar.getStudents().add(student);
        System.out.println("Student '" + student.getName() + "' added into '" + seminar.getTitle() + "' seminar's successfully");
    }

    public static Seminar registerSeminar(Scanner input) {
        System.out.println("Chose the title:");
        String seminarTitleResponse = input.nextLine().trim();

        if (seminarTitleResponse.isEmpty()){
            System.out.println("Nothing typed, finishing process...");
            return null;
        }


        if (locals.isEmpty()){
            System.out.println("No locals registered, do you like to register one and associate this local with this seminar?: ");
            String registerLocalResponse = input.nextLine().trim();
            if (!registerLocalResponse.equalsIgnoreCase("Y")){
                System.out.println("Finishing process...");
                return null;
            }
            Local registeredLocal = registerLocal(input);
            if (registeredLocal == null) return null;
        }


        for (Local item : locals){
            System.out.println(item.getAddress());
        }
        System.out.println("Chose the local:");
        String localChosen = input.nextLine().trim();
        Local local = locals.stream()
                .filter(l -> l.getAddress().equalsIgnoreCase(localChosen))
                .findFirst()
                .orElse(null);

        if (local == null){
            System.out.println("Local not found, finishing operation...");
            return null;
        }

        Seminar seminar = new Seminar(seminarTitleResponse, local);
        local.registerSeminarInLocal(seminar);
        return seminar;
    }

    public static Local registerLocal(Scanner input){
        System.out.println("Type the address: ");
        String addressResponse = input.nextLine().trim();
        if (addressResponse.isEmpty()){
            System.out.println("Finishing operation, Address can't be empty...");
            return null;
        }
        Local local = new Local(addressResponse);
        locals.add(local);
        System.out.println("log: Local added to local list");
        return local;
    }

    public static void registerTeacher(Scanner input){
        System.out.println("Type teacher's name: ");
        String teachersName = input.nextLine().trim();
        if (teachersName.isEmpty()){
            System.out.println("'Name' Field is empty, operation isn't continued...");
            return;
        }

        System.out.println("Type teacher's specialty: ");
        String teachersSpecialty = input.nextLine().trim();
        if (teachersSpecialty.isEmpty()){
            System.out.println("'Name' Field is empty, operation isn't continued...");
            return;
        }
        Teacher teacher = new Teacher(teachersName, teachersSpecialty);
        teachers.add(teacher);
    }

    public static Teacher chooseTeacher(@NotNull List<Teacher> teachers, @NotNull Scanner input) {

        if (teachers.isEmpty()){
            System.out.println("No teachers, do you like to register?: ");
            String createTeacherResponse = input.nextLine().trim();

            if (!createTeacherResponse.equalsIgnoreCase("Y")){
                System.out.println("Finishing operation...");
                return null;
            }

            registerTeacher(input);
        }

        System.out.println("What teacher are you?");
        // TODO: Make it beautiful;
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + " " + teachers.get(i).getName());
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
