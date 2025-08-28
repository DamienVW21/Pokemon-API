package org.example;

import org.example.models.Pokemon;
import org.example.services.DadJokeService;
import org.example.services.PokemonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //SOLID
        // /SRP - single responsibility principle
        DadJokeService jokeService = new DadJokeService();

        String joke = jokeService.getDadJoke();
        System.out.println(joke);

        // create pokemonservice object to query the api
        PokemonService pokemonService = new PokemonService();
        // it returns a list of pokemon objects
        List<Pokemon> list = pokemonService.getAllPokemon();
        System.out.println(list);
    }
}



