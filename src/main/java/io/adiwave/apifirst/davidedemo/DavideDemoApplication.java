package io.adiwave.apifirst.davidedemo;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;


@SpringBootApplication
@EnableR2dbcRepositories
@ConfigurationPropertiesScan
@Slf4j
public class DavideDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DavideDemoApplication.class, args);
    }


//    @Bean
//    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        initializer.setConnectionFactory(connectionFactory);
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("schema-hiding.sql"));
//        initializer.setDatabasePopulator(populator);
//        return initializer;
//    }

}
