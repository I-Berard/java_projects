package com.example.demo1;

public class Engine {
    private String model;

    Engine(String model){
        this.model = model;
        System.out.println("Engine created");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
