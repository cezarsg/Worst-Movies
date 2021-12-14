package br.com.golden;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorstMoviesApplication {

	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(WorstMoviesApplication.class, args);
	}
	
	private void loadCSV() {
		 entityManager.createNativeQuery("CREATE TABLE MOVIES(year INT, title VARCHAR(255), studios VARCHAR(255), producers VARCHAR(255), winner VARCHAR(255))) AS SELECT * FROM CSVREAD('movieslist.csv');").executeUpdate();
		
	}

}
