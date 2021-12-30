package br.com.golden.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
    @Id
    @GeneratedValue
    private int id;
    
	private int year;
	private String title;
	private String studios;
	private String producers;
	private boolean winner;
	
	public Movie() {
		
	}
	
	public Movie(int year, String title, String studios, String producers, boolean winner) {
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
	
	public boolean isWinner() {
		return winner;
	}

	@Override
	public String toString() {
		return "Movie [year=" + year + ", title=" + title + ", studios=" + studios + ", producers=" + producers
				+ ", winner=" + winner + "]";
	}	
}
