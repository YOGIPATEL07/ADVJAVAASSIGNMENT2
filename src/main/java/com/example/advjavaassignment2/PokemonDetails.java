package com.example.advjavaassignment2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonDetails {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("supertype")
    private String supertype;
    @SerializedName("level")
    private String level;
    @SerializedName("hp")
    private String hp;
    @SerializedName("evolvesFrom")
    private String evolvesFrom;
    @SerializedName("images")
    private PokemonImages images;
    private List<String> types;

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSupertype() {
        return supertype;
    }

    public String getLevel() {
        return level;
    }

    public String getHp() {
        return hp;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public PokemonImages getImages() {
        return images;
    }

    public List<String> getTypes() {
        return types;
    }

    // Nested class for images
    public static class PokemonImages {
        @SerializedName("small")
        private String small;

        public String getSmallImage() {
            return small;
        }
    }

    public static class Data {
        @SerializedName("data")
        private PokemonDetails details;

        public PokemonDetails getDetails() {
            return details;
        }
    }
}
