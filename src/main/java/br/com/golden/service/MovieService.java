package br.com.golden.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univocity.parsers.common.record.Record;

import br.com.golden.WorstMoviesApplication;
import br.com.golden.dao.MovieRepository;
import br.com.golden.model.Movie;
import br.com.golden.util.CSVParserUtil;

@Component
public class MovieService implements IMovieService {
	
	@Autowired
	private MovieRepository movieRepository;	
	
	
	public MovieService() {
	}

	@Override
	public void upload(InputStream inputStream) {
		movieRepository.deleteAll();
		List<Record> records = CSVParserUtil.toRecords(inputStream);
		List<Movie> movies = CSVParserUtil.toMovies(records);
		
		movieRepository.saveAll(movies);		
	}

	@Override
	public void upload() {
		InputStream inputStream = WorstMoviesApplication.class.getResourceAsStream("/movielist.csv");
		List<Record> records = CSVParserUtil.toRecords(inputStream);
		List<Movie> movies = CSVParserUtil.toMovies(records);
		
		movieRepository.saveAll(movies);		
	}

}
