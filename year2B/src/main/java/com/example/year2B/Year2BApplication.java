package com.example.year2B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Year2BApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Year2BApplication.class, args);
		Car car=context.getBean(Car.class);

		System.out.println(car.getEngine());
	}

}
