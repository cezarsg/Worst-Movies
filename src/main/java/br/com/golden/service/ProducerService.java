package br.com.golden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.golden.dao.ProducerRepository;
import br.com.golden.model.Movie;
import br.com.golden.model.Winners;

public class ProducerService {
	
	@Autowired
	private ProducerRepository producerDao;

	public Winners retrieveWinners() {
		
		List<Movie> listMovies = producerDao.findAll();
		
		return new Winners();
	}

}
