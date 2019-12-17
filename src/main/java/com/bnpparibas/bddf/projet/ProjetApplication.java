package com.bnpparibas.bddf.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjetApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
		System.out.println("hello world");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "PUT", "POST","DELETE");
	}

}
