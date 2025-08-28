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
    public List<Pokemon> getMorePokemon(int startVal){
        String moreUrl = API_URL + "offset=" + startVal + "&limit=20";

        Results rs = restClient
                .get()
                .uri(moreUrl)
                .retrieve()
                .body(Results.class);
        List<Pokemon> list = rs.getResults();

        // Want to loop through the list of pokemon obj.
        // need to parse out the id number and add to each pokemon object

        for (Pokemon p : list){
            String url = p.getUrl(); // grabbing url here
            // now need index of where pokemon/ is in the url
            int pokemonIndex = url.indexOf("pokemon/");

            // pokemon/id/
            String pokemonUrl = url.substring(pokemonIndex);

            int slashIndex = pokemonUrl.indexOf("/");
            int pokemonId =
                    Integer.parseInt(pokemonUrl.substring(slashIndex + 1, pokemonUrl.length() - 1));
            p.setId(pokemonId);
        }
        return list;
    }
}
