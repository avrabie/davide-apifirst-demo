package io.adiwave.apifirst.davidedemo.demo;

import io.adiwave.apifirst.davidedemo.entity.Book;
import io.adiwave.apifirst.davidedemo.repository.BookRepository;
import io.adiwave.apifirst.davidedemo.repository.CustomerRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;

@Component
@Configuration
@Profile("loadSomeData")
@Log
public class LoadSomeData {

    final BookRepository bookRepository;

    public LoadSomeData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        System.out.println("LoadSomeData has been triggered");


    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData2() {
        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.save(book1).subscribe(System.out::println);
        bookRepository.save(book2).subscribe(book -> log.info("Book saved: " + book));
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {

        return (args) -> {
            // save a few customers
            repository.saveAll(Arrays.asList(
                            Customer.builder().firstName("Jack").lastName("Bauer").build(),
                            Customer.builder().firstName("Chloe").lastName("O'Brian").build(),
                            Customer.builder().firstName("Kim").lastName("Bauer").build(),
                            Customer.builder().firstName("David").lastName("Palmer").build(),
                            Customer.builder().firstName("Michelle").lastName("Dessler").build()))
                    .blockLast(Duration.ofSeconds(10));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().doOnNext(customer -> {
                log.info(customer.toString());
            }).blockLast(Duration.ofSeconds(10));

            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L).doOnNext(customer -> {
                log.info("Customer found with findById(1L):");
                log.info("--------------------------------");
                log.info(customer.toString());
                log.info("");
            }).block(Duration.ofSeconds(10));


            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").doOnNext(bauer -> {
                log.info(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));
            log.info("");
        };
    }
}
