package org.example.services;

import org.example.models.Pokemon;
import org.example.models.Results;
import org.springframework.web.client.RestClient;

import java.util.List;

public class PokemonService {
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    private RestClient restClient = RestClient.create();

    public List<Pokemon> getAllPokemon(){
        Results rs = restClient
                .get()
                .uri(API_URL)
                .retrieve()
                .body(Results.class);
        return rs.getResults();
    }
}
