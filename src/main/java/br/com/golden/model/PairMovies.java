package br.com.golden.model;

public class PairMovies {
	private Movie first;
	private Movie next;
	private int interval;
	
	public PairMovies(Movie first, Movie next) {
		this.first = first;
		this.next = next;
		int diff = getFirst().getYear() - getNext().getYear();
		
		this.interval = diff > 0 ? diff : diff * -1;
	}

	public int getInterval() {		
		return this.interval;		
	}

	public Movie getFirst() {
		return first;
	}

	public Movie getNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PairMovies [first=" + first.getTitle() + ", next=" + next.getTitle() + ", interval=" + interval + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		PairMovies other = (PairMovies) o;
		
		return other.getFirst().getTitle().contentEquals(this.first.getTitle()) 
				&& other.getNext().getTitle().contentEquals(this.next.getTitle());
	}	

}
