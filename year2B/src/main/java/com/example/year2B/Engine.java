package com.example.year2B;

import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    Engine(){
        System.out.println("Engine created");
    }
}
