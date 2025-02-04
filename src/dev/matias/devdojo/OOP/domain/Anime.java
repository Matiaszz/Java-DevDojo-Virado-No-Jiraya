package dev.matias.devdojo.OOP.domain;

import lombok.Data;

@Data
public class Anime {
    private String name;
    private String type;
    private int episodes;
    private String genre;

    public void init(String name, String type, int episodes){
        this.name = name;
        this.type = type;
        this.episodes = episodes;
    }

    public void init(String name, String type, int episodes, String genre){
        this.init(name, type, episodes);
        this.genre = genre;
    }

    public void printAnimeInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("Episodes: " + this.episodes);
        System.out.println("Genre: " + this.genre);
    }
}
