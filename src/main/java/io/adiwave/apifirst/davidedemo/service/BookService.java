package io.adiwave.apifirst.davidedemo.service;

import io.adiwave.apifirst.davidedemo.model.Book;
import io.adiwave.apifirst.davidedemo.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Mono<String> createbook(Mono<Book> book) {

        return book.map(book1 -> io.adiwave.apifirst.davidedemo.entity.Book.of(book1))
                .flatMap(bookRepository::save)
                .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn)
                .onErrorResume(RuntimeException.class, Mono::error);

    }
}
