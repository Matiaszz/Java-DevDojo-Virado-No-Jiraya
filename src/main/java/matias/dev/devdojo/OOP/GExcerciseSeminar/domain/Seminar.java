package matias.dev.devdojo.OOP.GExcerciseSeminar.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seminar {
    private String title;
    @ToString.Exclude
    private List<Student> students = new ArrayList<>();
    private Local local;

    public Seminar(String title, Local local){
        this.title = title;
        this.local = local;
    }

    public boolean studentIsInSeminar(Student student){
        return students.contains(student);
    }

    public List<Student> registerStudent(Student student){
        if (studentIsInSeminar(student)) return null;

        this.students.add(student);
        return this.students;
    }
}
