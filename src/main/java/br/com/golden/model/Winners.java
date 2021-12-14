package br.com.golden.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private List<WinnerProducer> min = new ArrayList<>();
	private List<WinnerProducer> max = new ArrayList<>();	
	
	public List<WinnerProducer> getMin() {
		return min;
	}	
	
	public List<WinnerProducer> getMax() {
		return max;
	}
	
	public void addMin(WinnerProducer min) {
		this.min.add(min);
	}
	
	public void addMax(WinnerProducer max) {
		this.max.add(max);
	}

}
