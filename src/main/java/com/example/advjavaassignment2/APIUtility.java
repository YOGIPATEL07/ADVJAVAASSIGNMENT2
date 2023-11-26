package com.example.advjavaassignment2;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class APIUtility {
    public static ApiResponse recieveAPI(String pokemonName) throws IOException, InterruptedException, IOException {

        pokemonName = pokemonName.replaceAll(" ", "%20");

        String uri = "https://api.pokemontcg.io/v2/cards?q=name:" + pokemonName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                                                     .ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ApiResponse.class);

     }
    public static PokemonDetails getpokemonDetails(String id) throws IOException, InterruptedException {
        //if we received "Star Wars", we need to translate that to be "Star%20Wars"
        id = id.trim().replaceAll(" ", "%20");

        String uri = "https://api.pokemontcg.io/v2/cards/"+id;

        //configure the environment to make a HTTP request (this includes an update to the
        //module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save a file called movies.json with the API's response
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                                                            .ofFile(Paths.get("movies.json")));

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), PokemonDetails.class);
    }
    public static ApiResponse getMoviesFromFile(String fileName)
    {
        Gson gson = new Gson();
        //this is called try...with resources when we use the ().
        //anything created inside the ( ) will automatically have the .close() called once
        //the resource is not required.
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            return gson.fromJson(jsonReader, ApiResponse.class);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    }
