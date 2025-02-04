package matias.dev.devdojo.OOP.Introdution.domain;

import lombok.Data;

@Data
public class Anime {
    private String name;
    private String type;
    private int episodes;
    private String genre;

    public Anime(){
        System.out.println("Inside of non-arguments constructor.");
    }
    public Anime(String name, String type, int episodes){
        this.name = name;
        this.type = type;
        this.episodes = episodes;
        System.out.println("Inside of 3 arguments constructor.");
    }

    public Anime(String name, String type, int episodes, String genre){
        this(name, type, episodes);
        this.genre = genre;
        System.out.println("Inside of 4 arguments constructor.");
    }

    public void printAnimeInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("Episodes: " + this.episodes);
        System.out.println("Genre: " + this.genre);
    }
}
