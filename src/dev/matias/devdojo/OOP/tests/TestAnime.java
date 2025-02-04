package dev.matias.devdojo.OOP.tests;


import dev.matias.devdojo.OOP.domain.Anime;
import lombok.Data;


public class TestAnime {
    public static void main(String[] args) {
        Anime anime = new Anime("Attack on Titan", "Shonen", 75, "Action");
        anime.printAnimeInfo();
    }
}
