package com.myprojects.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API documentation",
				description = "Product service REST API",
				version = "v1",
				contact = @Contact(
						name = "Mihir Kumar Meher",
						email = "mihirkumar123@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint URL Product API",
				url = "example.com"
		)
)
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
