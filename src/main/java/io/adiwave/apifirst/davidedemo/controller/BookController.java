package io.adiwave.apifirst.davidedemo.controller;

import io.adiwave.apifirst.davidedemo.api.BooksApi;
import io.adiwave.apifirst.davidedemo.model.Book;
import io.adiwave.apifirst.davidedemo.service.BookService;
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
        return responseBookId.map(isbn ->  ResponseEntity.created(URI.create("/api/v1/book/" + isbn)).build());

    }

    @Override
    public Mono<ResponseEntity<Void>> deletebook(String bookId, ServerWebExchange exchange) {
        return BooksApi.super.deletebook(bookId, exchange);
    }

    @Override
    public Mono<ResponseEntity<Book>> getbook(String bookId, ServerWebExchange exchange) {
        return BooksApi.super.getbook(bookId, exchange);
    }

    @Override
    public Mono<ResponseEntity<Flux<Book>>> getbooks(ServerWebExchange exchange) {
        return BooksApi.super.getbooks(exchange);
    }

    @Override
    public Mono<ResponseEntity<Void>> updatebook(String bookId, Mono<Book> book, ServerWebExchange exchange) {
        return BooksApi.super.updatebook(bookId, book, exchange);
    }
}
