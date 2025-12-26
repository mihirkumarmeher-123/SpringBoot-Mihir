package com.myprojects.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductApplication {
	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
//		MyComponent myComponent = context.getBean(MyComponent.class);
//		myComponent.getMessage();

//		MyApp myApp = context.getBean(MyApp.class);
//		myApp.run();

//		MyComponent myComponent = new MyComponent();
//		System.out.println("Application Started");

		SpringApplication.run(ProductApplication.class, args);
	}
}
