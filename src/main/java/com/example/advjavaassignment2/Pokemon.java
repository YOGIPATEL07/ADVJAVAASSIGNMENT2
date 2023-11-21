package com.example.advjavaassignment2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
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
    @SerializedName("images")
    private PokemonImages images;
    private List<String> types;

    public String getId() {
        return id;
    }

    public List<String> getTypes() {
        return types;
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
    public PokemonImages getImages() {
        return images;
    }

    class PokemonImages {
        @SerializedName("small")
        private String small;

        public String getSmallImage() {
            return small;
        }
    }

    @Override
    public String toString() {
        return String.format("%s-%s",name, types);
    }
}
