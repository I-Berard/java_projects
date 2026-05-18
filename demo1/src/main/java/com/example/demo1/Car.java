package com.example.demo1;

public class Car {
    Engine engine;
    Car(Engine engine){
        this.engine = engine;
        System.out.println("Engine in car0 " + engine.getModel() + " " + engine);
    }
}
