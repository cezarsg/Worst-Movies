package br.com.golden.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private List<WinnerProducer> min = new ArrayList<>();
	private List<WinnerProducer> max = new ArrayList<>();	
	
	public Winners(List<WinnerProducer> max, List<WinnerProducer> min) {
		this.min = min;
		this.max = max;
	}

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
