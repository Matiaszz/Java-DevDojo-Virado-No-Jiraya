package matias.dev.devdojo.OOP.GExcerciseSeminar.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Local {
    private String address;
    @ToString.Exclude
    private List<Seminar> listOfSeminaries = new ArrayList<>();

    public Local(String address){
        this.address = address;
    }

    public boolean seminarAlreadyInLocal(Seminar seminar){
        return listOfSeminaries.contains(seminar);
    }

    public void registerSeminarInLocal(Seminar seminar){
        if (seminarAlreadyInLocal(seminar)){
            System.out.println("Seminar already is in this local");
            return;
        }
        this.listOfSeminaries.add(seminar);
    }


}
