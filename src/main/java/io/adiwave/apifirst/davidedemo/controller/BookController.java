package io.adiwave.apifirst.davidedemo.controller;

import io.adiwave.apifirst.davidedemo.api.BooksApi;
import io.adiwave.apifirst.davidedemo.model.Book;
import io.adiwave.apifirst.davidedemo.service.BookService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class BookController implements BooksApi {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Mono<ResponseEntity<Void>> createbook(Mono<Book> book, ServerWebExchange exchange) {
        Mono<String> responseBookId = bookService.createbook(book);
        return responseBookId
                .map(isbn ->  ResponseEntity.created(URI.create("/api/v1/book/" + isbn)).<Void>build())
                .onErrorReturn(DuplicateKeyException.class, ResponseEntity.badRequest().header("error-details","Not created due to dublicate key").<Void>build())
                .onErrorReturn(RuntimeException.class, ResponseEntity.badRequest().header("error-details","Not created due to some RuntimeException").<Void>build());

    }

    @Override
    public Mono<ResponseEntity<Void>> deletebook(String bookId, ServerWebExchange exchange) {
        return bookService.deletebook(bookId)
                .map(aVoid -> ResponseEntity.noContent().<Void>build())
                .onErrorReturn(DataAccessException.class, ResponseEntity.badRequest().header("error-details","Not deleted due to some RuntimeException").<Void>build());

    }

    @Override
    public Mono<ResponseEntity<Book>> getbook(String bookId, ServerWebExchange exchange) {
        return BooksApi.super.getbook(bookId, exchange);
    }

    @Override
    public Mono<ResponseEntity<Flux<Book>>> getbooks(ServerWebExchange exchange) {
        Flux<Book> getbooks = bookService.getbooks();
        Mono<ResponseEntity<Flux<Book>>> map = Mono.just(ResponseEntity.ok(getbooks));

        return map;


    }

    @Override
    public Mono<ResponseEntity<Void>> updatebook(String bookId, Mono<Book> book, ServerWebExchange exchange) {
        Mono<Book> bookMono = bookService.updateBook(bookId, book);
        return bookMono
                .map(book1 -> ResponseEntity.created(URI.create("whatever" +book1.getIsbn())).<Void>build())
                .onErrorReturn(RuntimeException.class, ResponseEntity.badRequest().header("error-details","Not updated due to some RuntimeException").<Void>build());





//                .onErrorReturn(RuntimeException.class, ResponseEntity.badRequest().header("book","Not updated due to some RuntimeException").<Void>build());
    }
}
