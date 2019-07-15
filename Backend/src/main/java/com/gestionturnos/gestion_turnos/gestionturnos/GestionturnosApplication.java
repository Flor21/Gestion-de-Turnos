package com.gestionturnos.gestion_turnos.gestionturnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author flor
 *
 */
@ComponentScan("com.gestionturnos.gestion_turnos.gestionturnos.controllers")
@EntityScan("com.gestionturnos.gestion_turnos.gestionturnos.model")
@EnableJpaRepositories("com.gestionturnos.gestion_turnos.gestionturnos.dao")
@SpringBootApplication
@EnableSwagger2
public class GestionturnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionturnosApplication.class, args);
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
