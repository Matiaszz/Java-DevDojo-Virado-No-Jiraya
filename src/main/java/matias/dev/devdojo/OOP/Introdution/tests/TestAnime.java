package matias.dev.devdojo.OOP.Introdution.tests;


import matias.dev.devdojo.OOP.Introdution.domain.Anime;


public class TestAnime {
    public static void main(String[] args) {
        Anime anime = new Anime("Attack on Titan", "Shonen", 75, "Action");
        anime.printAnimeInfo();
    }
}
