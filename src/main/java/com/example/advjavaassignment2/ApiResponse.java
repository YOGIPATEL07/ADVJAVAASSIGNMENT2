package com.example.advjavaassignment2;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ApiResponse {
    private String totalCount;
    @SerializedName("data")
    private ArrayList<Pokemon> pokemons;

    // Getters
    public String getTotalData() {
        return totalCount;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
