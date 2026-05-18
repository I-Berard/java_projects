package com.example.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Engine engine(){
        return new Engine("24.4");
    }

    @Bean
    public Car car(){
        return new Car(engine());
    }
}
