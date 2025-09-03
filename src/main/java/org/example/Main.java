package org.example;

import org.example.models.Pokemon;
import org.example.services.DadJokeService;
import org.example.services.PokemonService;

import java.util.List;
import java.util.Scanner;

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

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Choose from the following menu:");
            System.out.println("1. return the first 20 pokemon");
            System.out.println("2. return the next 20 pokemon");
            System.out.println("3. return the next 20 pokemon");
            System.out.println("5. quit");
            System.out.println("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());
            int startVal = 0;

        switch (choice){
            case 1:
                break;
            case 2:
                startVal = 20;
                break;
            case 3:
                startVal = 40;
                break;
            case 4:
                startVal = 60;
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Entry - try again");
        }
        if (choice == 5){
            break;
        }
            // it returns a list of pokemon objects
            List<Pokemon> list = pokemonService.getMorePokemon(startVal);
            System.out.println(list);
        }
    }
}



