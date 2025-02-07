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

    public void registerSeminarInOwnedSeminars(Seminar seminar){
        if (seminarInOwnedSeminars(seminar)) return;

        this.seminars.add(seminar);
    }

}
