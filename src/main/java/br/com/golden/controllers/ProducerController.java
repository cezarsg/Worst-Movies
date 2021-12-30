package br.com.golden.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.golden.WorstMoviesApplication;
import br.com.golden.model.Winners;
import br.com.golden.service.IMovieService;
import br.com.golden.service.IProducerService;

@RestController
public class ProducerController {
	
	
	@Autowired
	private IProducerService producerService;
	
	@Autowired
	private IMovieService movieService;

	@GetMapping("/winners")
	public Winners retrieveWinners() {
		InputStream inputStream = WorstMoviesApplication.class.getResourceAsStream("/movielist.csv");
		movieService.upload(inputStream);

		return producerService.retrieveWinners();
	}	
	
	
	@GetMapping("/upload")
	public String uploadWinners(@RequestParam("file") MultipartFile file) {
		try {
			movieService.upload(file.getInputStream());
		} catch (IOException e) {			
			e.printStackTrace();
			return "failed - " + e.getMessage();
		}
		
		return "success";
	}	

}
