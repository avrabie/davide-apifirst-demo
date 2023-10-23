package io.adiwave.apifirst.davidedemo.repository;

import io.adiwave.apifirst.davidedemo.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
