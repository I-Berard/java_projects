package com.example.year2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    Car(Engine engine){
        this.engine = engine;
        System.out.println("Car created");
    }

    public Engine getEngine() {
        return engine;
    }
}
