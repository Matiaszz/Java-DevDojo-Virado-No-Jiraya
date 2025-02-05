package matias.dev.devdojo.OOP.EIinicializationBlocks.tests;

import matias.dev.devdojo.OOP.EIinicializationBlocks.domain.Anime;

import java.util.Arrays;

public class TestAnime {
    public static void main(String[] args) {
        Anime anime = new Anime("Attack on titan");
        for (int ep : anime.getEpisodes()){
            System.out.println(ep);
        }
    }
}
