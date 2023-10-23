package io.adiwave.apifirst.davidedemo;

import io.adiwave.apifirst.davidedemo.demo.Customer;
import io.adiwave.apifirst.davidedemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
@EnableR2dbcRepositories
@ConfigurationPropertiesScan
@Slf4j
public class DavideDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DavideDemoApplication.class, args);
    }



}
