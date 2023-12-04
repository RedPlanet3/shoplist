package ru.pryakhina.shoplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication
public class ShoplistApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoplistApplication.class, args);
	}
}
