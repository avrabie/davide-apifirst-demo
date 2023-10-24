package io.adiwave.apifirst.davidedemo.service;

import io.adiwave.apifirst.davidedemo.model.Book;

import io.adiwave.apifirst.davidedemo.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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


//        Mono<Book> share = book.share();
//        return book.map(book1 -> book1.getIsbn())
//                .flatMap(bookRepository::findByIsbn)
//                .doFirst(() -> new RuntimeException("Book already exists"))
//                .switchIfEmpty(share.map(book1 -> io.adiwave.apifirst.davidedemo.entity.Book.of(book1)))
//                .flatMap(bookRepository::save)
//                .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn);





//        Mono<io.adiwave.apifirst.davidedemo.entity.Book> iaka = book.map(io.adiwave.apifirst.davidedemo.entity.Book::of);
//        return book.map(Book::getIsbn)
//                .flatMap(isbn -> bookRepository.findByIsbn(isbn))
//                .doOnNext(book1 -> System.out.println("Book found: " + book1))
//                .flatMap(book1 -> Mono.error(new RuntimeException("Book already exists")))
//                .switchIfEmpty(Mono.defer(() -> book.map(io.adiwave.apifirst.davidedemo.entity.Book::of))
//                        .flatMap(book1 -> bookRepository.save(book1))
//                        .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn));


//        return bookRepository.save(iaka)
//                .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn).onErrorComplete(RuntimeException.class);
//        Flux<io.adiwave.apifirst.davidedemo.entity.Book> bookFlux = bookRepository.saveAll(iaka)
//                .onErrorReturn(RuntimeException.class, io.adiwave.apifirst.davidedemo.entity.Book.of("0", "No Title", "No Author", 9.90));
//        return bookFlux.map(io.adiwave.apifirst.davidedemo.entity.Book::isbn).next()
//                .onErrorComplete(RuntimeException.class);
//
//        double random = Math.random();
//        if (random < 0.5) {
//            return Mono.error(()-> new RuntimeException("Could not save to the DB"));
//        }
//        return Mono.just("1234");
    }
}
