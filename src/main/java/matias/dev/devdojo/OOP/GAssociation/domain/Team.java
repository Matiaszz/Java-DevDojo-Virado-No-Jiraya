package matias.dev.devdojo.OOP.GAssociation.domain;

import lombok.Data;

import java.util.Arrays;

@Data
public class Team {
    private String name;
    private Player[] players;


    public Team(){}

    public Team(String name){
        this.name = name;
    }

    public Team(String name, Player[] players){
        this(name);
        this.players = players;
        for (Player player : players) player.setTeam(this);
    }

    public void showInfo(){
        if (this.players == null) return;
        for (Player player : this.players){
            System.out.println(player.getName());
        }
    }

}
