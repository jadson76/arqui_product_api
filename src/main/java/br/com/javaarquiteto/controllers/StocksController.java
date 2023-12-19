package br.com.javaarquiteto.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaarquiteto.commands.StockCreateCommand;
import br.com.javaarquiteto.dtos.StockDto;
import br.com.javaarquiteto.services.interfaces.StockService;

@RestController
@RequestMapping(value = "/api/stocks")
public class StocksController {
	
	@Autowired
	StockService service;
	
	@PostMapping
	public StockDto post( @RequestBody StockCreateCommand command ) {
		return service.create(command);
	}
	
	@GetMapping
	public List<StockDto> getAll() {
		return service.findAll();
	}
	@GetMapping("{id}")
	public StockDto GetById(@PathVariable("id") UUID id) {
		return service.findById(id);
	}

}
