package matias.dev.devdojo.OOP.EIinicializationBlocks.domain;


import lombok.Data;

@Data
public class Anime {
    private String name;
    private int[] episodes;

    // 1 - reserve a space in memory
    // 2 - each attribute is created and initialized with default values or something else passed
    // 3 - initialization block is executed
    // 4 - builder is executed

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