package matias.dev.devdojo.OOP.GAssociation.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;


@Data
public class Player {
    private String name;

    // Fix the infinite loop of toString Method;
    @ToString.Exclude
    private Team team;


    public Player(){}

    public Player(String name){
        this.name = name;
    }
    public Player(String name, Team team){
        this(name);
        this.team = team;
    }

    public void showInfo(){
        System.out.println("Player: " + this.name + " " + (this.team != null ? this.team.getName() : "No team assigned"));
    }

}
