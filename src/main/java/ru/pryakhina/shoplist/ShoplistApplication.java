package ru.pryakhina.shoplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication(scanBasePackages = "com.baeldung.boot.jsp")
@SpringBootApplication
public class ShoplistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoplistApplication.class, args);
	}
}
