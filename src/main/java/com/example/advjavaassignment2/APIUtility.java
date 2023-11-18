package com.example.advjavaassignment2;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
    //RECIEVE THE API
    public static ResponseApi recieveAPI(String pokemonName) throws IOException, InterruptedException, IOException {

        pokemonName = pokemonName.replaceAll(" ", "%20");

        String uri = "https://api.pokemontcg.io/v2/cards?q=name:" + pokemonName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ResponseApi.class);

    }
    }
