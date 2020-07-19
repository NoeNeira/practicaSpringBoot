package com.noelia.practica.api.quotes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class QuoteController {

    @GetMapping("/quotes")
    public Quote getQuotes(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("https://gturnquist-quoters.cfapps.io/api/random");
        Quote quote = restTemplate.getForObject(uri, Quote.class);
        return quote;
    }

}
