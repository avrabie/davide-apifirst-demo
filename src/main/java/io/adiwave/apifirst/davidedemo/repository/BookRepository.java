package io.adiwave.apifirst.davidedemo.repository;

import io.adiwave.apifirst.davidedemo.entity.Book;
import io.micrometer.common.util.internal.logging.InternalLogger;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    Mono<Book> findByIsbn(String isbn);

    Mono<Void> deleteByIsbn(String isbn);
}
