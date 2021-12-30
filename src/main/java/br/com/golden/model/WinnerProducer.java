package br.com.golden.model;

public class WinnerProducer {
	
	private String producer;
	private int interval;
	private int previousWin;
	private int followingWin;
	
	public WinnerProducer(String producer, int interval, int previousWin, int followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public int getInterval() {
		return interval;
	}	

	public int getPreviousWin() {
		return previousWin;
	}
	
	public int getFollowingWin() {
		return followingWin;
	}

}
