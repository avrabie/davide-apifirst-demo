package io.adiwave.apifirst.davidedemo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@ConfigurationProperties(prefix = "polar")
@Data
@RefreshScope
public class GreetingsController {

    private String message;

    @GetMapping("/iaka")
    Mono<String> iaka() {
        return Mono.just("Hello World! " + this.message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
