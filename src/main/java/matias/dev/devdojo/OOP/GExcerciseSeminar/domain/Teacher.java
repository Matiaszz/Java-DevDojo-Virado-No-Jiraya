package matias.dev.devdojo.OOP.GExcerciseSeminar.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Teacher {
    private String name;
    private String specialty;
    @ToString.Exclude
    private List<Seminar> seminars = new ArrayList<>();

    public Teacher(String name, String specialty){
        this.name = name;
        this.specialty = specialty;
    }

    public boolean seminarInOwnedSeminars(Seminar seminar){
        return this.seminars.contains(seminar);
    }

    public List<Seminar> registerSeminarInOwnedSeminars(Seminar seminar, Local local){
        if (seminarInOwnedSeminars(seminar)) return null;

        this.seminars.add(seminar);
        local.registerSeminarInLocal(seminar);
        return this.seminars;
    }

}
