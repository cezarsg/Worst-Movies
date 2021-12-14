package br.com.golden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.golden.model.Winners;
import br.com.golden.service.ProducerService;

@RestController
public class ProducerController {
	
	
	@Autowired
	private ProducerService producerService;

	@GetMapping("/winners")
	public Winners retrieveWinners() {
		return producerService.retrieveWinners();
	}	

}
