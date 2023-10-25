package io.adiwave.apifirst.davidedemo.service;

import io.adiwave.apifirst.davidedemo.model.Book;
import io.adiwave.apifirst.davidedemo.repository.BookRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Mono<String> createbook(Mono<Book> book) {

        return book.map(io.adiwave.apifirst.davidedemo.entity.Book::of)
                .flatMap(bookRepository::save)
//                .switchIfEmpty(Mono.error(new RuntimeException("Error while saving book 1")))
                .log()
                .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn)
                .map(isbn -> {
                    if (isbn.equals("123")) {
                        throw new ArithmeticException("Isbn 123 is not allowed");
                    }
                    return isbn;
                })
//                .onErrorResume(DuplicateKeyException.class, e -> Mono.error(new DuplicateKeyException("Error while saving book", e)))
//                .onErrorResume(ArithmeticException.class, e -> Mono.error(new RuntimeException("Whatever bs exception", e)));
                .onErrorResume(RuntimeException.class, Mono::error);

    }
}
