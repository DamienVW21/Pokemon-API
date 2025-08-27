package org.example.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;



public class DadJokeService {

    private final String API_URL = "https://icanhazdadjoke.com";

    private RestClient restClient = RestClient.create();
    // RestClient.create() --  sets uip the restClient object so we can
    // use it to query an API

    public String getDadJoke(){
        String response = restClient
                .get()
                .uri(API_URL)
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                // this header is added to make the response come back
                // in plain text not html
                .retrieve()
                .body(String.class);
        return response;

    }
}
