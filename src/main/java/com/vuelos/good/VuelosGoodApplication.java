package com.vuelos.good;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class VuelosGoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuelosGoodApplication.class, args);
	}

}
