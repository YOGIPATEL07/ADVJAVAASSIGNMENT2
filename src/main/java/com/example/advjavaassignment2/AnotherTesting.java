package com.example.advjavaassignment2;

public class AnotherTesting {
    public static void main(String[] args) {
        ApiResponse apiResponse = APIUtility.getPokemonFile("pokemon.json");
        System.out.println(apiResponse);
    }
}
