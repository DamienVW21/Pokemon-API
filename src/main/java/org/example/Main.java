package org.example;

import org.example.services.DadJokeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //SOLID
        // /SRP - single responsibility principle
        DadJokeService jokeService = new DadJokeService();

        String joke = jokeService.getDadJoke();
        System.out.println(joke);
    }
}