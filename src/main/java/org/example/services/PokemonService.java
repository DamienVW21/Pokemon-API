package org.example.services;

import org.springframework.web.client.RestClient;

public class PokemonService {
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    private RestClient restClient = RestClient.create();
}
