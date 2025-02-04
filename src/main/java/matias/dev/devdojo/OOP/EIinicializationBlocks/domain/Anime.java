package matias.dev.devdojo.OOP.EIinicializationBlocks.domain;


import lombok.Data;

@Data
public class Anime {
    private String name;
    private int[] episodes;

    {
        episodes = new int[100];
        for (int i = 0; i < episodes.length; i++) { // Changed to i < episodes.length
            this.episodes[i] = i + 1; // Use assignment instead of +=
        }
    }

    public Anime() {}

    public Anime(String name) {
        this.name = name;
    }
}