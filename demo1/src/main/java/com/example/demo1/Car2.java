package com.example.demo1;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car2 {

    @Autowired
    private Engine engine;

    @PostConstruct
    public void init() {
        System.out.println("Engine in car2 " + engine.getModel() + " " + engine);
    }
}
