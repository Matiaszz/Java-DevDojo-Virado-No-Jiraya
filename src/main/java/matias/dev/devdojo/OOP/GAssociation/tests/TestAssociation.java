package matias.dev.devdojo.OOP.GAssociation.tests;

import matias.dev.devdojo.OOP.GAssociation.domain.Player;
import matias.dev.devdojo.OOP.GAssociation.domain.Team;

public class TestAssociation {


    public static void main(String[] args) {
        Player matias = new Player("Matias");
        Player john = new Player("John");

        john.showInfo();


        Player[] players = {matias, john};
        Team loud = new Team("LOUD", players);

        System.out.println("---------------- Team info ----------------");
        loud.showInfo();

        System.out.println("---------------- Player info -------------------");
        john.showInfo();

        System.out.println();

        matias.showInfo();
    }
}
