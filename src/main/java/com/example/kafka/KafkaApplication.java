package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
	@Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurerAdapter() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowedOrigins("*");
           }
       };
   }

}
