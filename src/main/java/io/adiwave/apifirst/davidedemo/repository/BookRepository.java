package io.adiwave.apifirst.davidedemo.repository;

import io.adiwave.apifirst.davidedemo.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
