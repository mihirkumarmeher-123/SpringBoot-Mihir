package com.myprojects.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Slf4j
public class ProductApplication {
	//To generate logs
//	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
//		MyComponent myComponent = context.getBean(MyComponent.class);
//		myComponent.getMessage();

//		MyApp myApp = context.getBean(MyApp.class);
//		myApp.run();

//		MyComponent myComponent = new MyComponent();w
//		System.out.println("Application Started");

		SpringApplication.run(ProductApplication.class, args);

		String str="test";
		log.info("Product Service REST API started successfully! {}",str);//{} -> called placeholder, avoid concatenation use placeholder instead
//		log.warn("This is warning log/message");
//		log.debug("This is debug message");
//		log.error("This is error message");
//		log.trace("This is trace message");
	}
}