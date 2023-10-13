package io.adiwave.apifirst.davidedemo.service;

import io.adiwave.apifirst.davidedemo.model.Book;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service

public class BookService {


    public Mono<String> createbook(Mono<Book> book) {
        // TODO: 10/13/2023 save the book in a Mongo DB and take the id form the DB

        double random = Math.random();
        if (random < 0.5) {
            return Mono.error(()-> new RuntimeException("Could not save to the DB"));
        }
        return Mono.just("1234");
    }
}
