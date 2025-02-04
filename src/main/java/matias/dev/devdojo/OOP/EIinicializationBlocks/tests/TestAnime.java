package matias.dev.devdojo.OOP.EIinicializationBlocks.tests;

import matias.dev.devdojo.OOP.EIinicializationBlocks.domain.Anime;

import java.util.Arrays;

public class TestAnime {
    public static void main(String[] args) {
        Anime anime = new Anime("Attack on titan");

        System.out.println(Arrays.toString(anime.getEpisodes()));
    }
}
