package br.com.golden;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorstMoviesApplication {

	@PersistenceContext
	private EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(WorstMoviesApplication.class, args);
	}
	

}
