package io.adiwave.apifirst.davidedemo.repository;

import io.adiwave.apifirst.davidedemo.entity.Book;
import io.micrometer.common.util.internal.logging.InternalLogger;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    Mono<Book> findByIsbn(String isbn);

    // I don't know if @Transactional is needed here since we are using Spring Data Jdbc, I wonder how it works
//    @Modifying
//    @Query("delete from Book where isbn = :isbn")
//    @Transactional
    Mono<Void> deleteByIsbn(String isbn);

    // TODO: 10/29/2023 to be implemented by @davide
    //    5.3 Testing data persistence with Spring and Testcontainers
}
