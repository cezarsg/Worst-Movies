package br.com.golden.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.golden.dao.MovieRepository;
import br.com.golden.model.Movie;
import br.com.golden.model.PairMovies;
import br.com.golden.model.WinnerProducer;
import br.com.golden.model.Winners;

@Component
public class ProducerService implements IProducerService {
	
	@Autowired
	private MovieRepository movieRepository;	
	
	private Comparator<PairMovies> comparator = Comparator.comparing( PairMovies::getInterval);
	
	public ProducerService() {
	}

	@Override
	public Winners retrieveWinners() {
		
		List<Movie> listMovies = retrievesWinners();		
		Map<String, List<Movie>> moviesByProducer = groupByProducers(listMovies);
		
		List<PairMovies> listPairMovies = createPairMovies(moviesByProducer);

		Winners winners = new Winners(retrieveMax(listPairMovies), retrieveMin(listPairMovies));
		
		return winners;	
	}
	
	private Map<String, List<Movie>> groupByProducers(List<Movie> listMovies) {
		return listMovies.stream().collect(Collectors.groupingBy(Movie::getProducers));
	}
	
	private List<Movie> retrievesWinners() {
		List<Movie> listMovies = movieRepository.findAll().stream().filter(m -> m.isWinner()).collect(Collectors.toList());
		return listMovies;
	}	

	private List<WinnerProducer> retrieveMin(List<PairMovies> listPairMovies) {
		List<WinnerProducer> winners = new ArrayList<>();
		
		if (!listPairMovies.isEmpty()) {
			PairMovies first = listPairMovies.stream().min(comparator).get();
			listPairMovies.remove(first);
			winners.add(createWinnerProducer(first));
		}
		
		if (!listPairMovies.isEmpty()) {
			PairMovies second = listPairMovies.stream().min(comparator).get();
			winners.add(createWinnerProducer(second));
		}		

		return winners;
	}

	private WinnerProducer createWinnerProducer(PairMovies pairMovie) {
		
		Movie first = pairMovie.getFirst();
		Movie next = pairMovie.getNext();
		
		WinnerProducer winner = new WinnerProducer(first.getProducers(), pairMovie.getInterval(), 
				first.getYear(), next.getYear());
		return winner;
	}

	private List<WinnerProducer> retrieveMax(List<PairMovies> listPairMovies) {
		
		List<WinnerProducer> winners = new ArrayList<>();
		 
		// Get Min or Max Object
		PairMovies first = listPairMovies.stream().max(comparator).get();
		listPairMovies.remove(first);
		winners.add(createWinnerProducer(first));
		
		if (!listPairMovies.isEmpty()) {
			PairMovies second = listPairMovies.stream().max(comparator).get();		
			winners.add(createWinnerProducer(second));
		}

		return winners;	
	}


	private List<PairMovies> createPairMovies(Map<String, List<Movie>> moviesByProducer) {
		List<PairMovies> movieComb = new ArrayList<>();
		long count = 0;
		
		for (Map.Entry<String, List<Movie>> entry : moviesByProducer.entrySet()) {
		    List<Movie> movies = entry.getValue();
		    if (movies.size() < 2) {
		    	continue;
		    }
		    
		    for (Movie first : movies) {
			    for (Movie next : movies) {
			    	count++;
			    	if (!first.getTitle().contentEquals(next.getTitle())) {
		    			PairMovies pair = null;

			    		if (first.getYear() < next.getYear()) {
			    			pair = new PairMovies(first, next);
			    		} else {
			    			pair = new PairMovies(next, first);
			    		}
			    		
			    		System.out.println(pair);
			    		if (!movieComb.contains(pair)) {
					    	movieComb.add(pair);
			    		}
			    	}
				}				
			}		
		}		
		
    	System.out.println("Adicionado " + count);

		return movieComb;
	}
	
}
