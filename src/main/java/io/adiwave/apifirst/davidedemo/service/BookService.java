package io.adiwave.apifirst.davidedemo.service;

import io.adiwave.apifirst.davidedemo.model.Book;
import io.adiwave.apifirst.davidedemo.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Mono<String> createbook(Mono<Book> book) {

        return book.map(io.adiwave.apifirst.davidedemo.entity.Book::of)
                .flatMap(bookRepository::save)
                .log()
                .map(io.adiwave.apifirst.davidedemo.entity.Book::isbn)
                .map(isbn -> {
                    if (isbn.equals("123")) {
                        throw new ArithmeticException("Isbn 123 is not allowed");
                    }
                    return isbn;
                })
                .onErrorResume(RuntimeException.class, Mono::error);

    }

    public Mono<Book> updateBook(String isbn, Mono<Book> book) {
        // TODO: 10/27/2023 consider reafctoring

//        Mono<Book> sharedBook = book.share();
        Mono<io.adiwave.apifirst.davidedemo.entity.Book> byIsbn = bookRepository.findByIsbn(isbn);

//        Mono<io.adiwave.apifirst.davidedemo.entity.Book> dbBook = book
//                .map(book1 -> book1.getIsbn())
//                .flatMap(bookRepository::findByIsbn)
//                .log()
//                .switchIfEmpty(Mono.error(new RuntimeException("Book not found")));

        return Mono.zip(book, byIsbn).map(tuple -> {

                    io.adiwave.apifirst.davidedemo.entity.Book book1 = io.adiwave.apifirst.davidedemo.entity.Book.of(
                            tuple.getT2().id(),
                            tuple.getT2().isbn(),
                            tuple.getT1().getTitle(),
                            tuple.getT1().getAuthor(),
                            tuple.getT1().getCost(),
                            tuple.getT2().version());
                    return book1;
                })
                .flatMap(bookRepository::save)
                .log()
                .then(book).log();



    }


}
