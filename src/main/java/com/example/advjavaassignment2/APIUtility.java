package com.example.advjavaassignment2;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static void recieveAPI(String pokemonName) throws IOException, InterruptedException, IOException {

        pokemonName = pokemonName.replaceAll(" ", "%20");

        String uri = "https://api.pokemontcg.io/v2/cards?q=name:" + pokemonName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                                          .ofFile(Paths.get("pokemon.json")));
    }
    }
