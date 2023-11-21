package com.example.advjavaassignment2;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ApiResponse {
    private int totalData;
    @SerializedName("data")
    private ArrayList<Pokemon> pokemons;

    // Getters
    public int getTotalData() {
        return totalData;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
