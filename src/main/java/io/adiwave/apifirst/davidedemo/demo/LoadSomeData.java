package io.adiwave.apifirst.davidedemo.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadSomeData {
    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        System.out.println("Hello from LoadSomeData");
    }
}
