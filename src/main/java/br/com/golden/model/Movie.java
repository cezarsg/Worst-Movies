package br.com.golden.model;

import javax.persistence.Entity;

@Entity
public class Movie {
	
	private int year;
	private String title;
	private String studios;
	private String producers;
	private String winner;
	
	public Movie() {
		
	}
	
	public Movie(int year, String title, String studios, String producers, String winner) {
		super();
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}	
	
	public int getYear() {
		return year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getStudios() {
		return studios;
	}
	
	public String getProducers() {
		return producers;
	}
	
	public String getWinner() {
		return winner;
	}

	@Override
	public String toString() {
		return "Movie [year=" + year + ", title=" + title + ", studios=" + studios + ", producers=" + producers
				+ ", winner=" + winner + "]";
	}	
}
