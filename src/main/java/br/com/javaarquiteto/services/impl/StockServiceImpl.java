package br.com.javaarquiteto.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javaarquiteto.commands.StockCreateCommand;
import br.com.javaarquiteto.dtos.StockDto;
import br.com.javaarquiteto.entities.Stock;
import br.com.javaarquiteto.repositories.mongodb.StockDtoRepository;
import br.com.javaarquiteto.repositories.postgresql.StockRepository;
import br.com.javaarquiteto.services.interfaces.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	StockDtoRepository stockDtoRepository;

	@Override
	public StockDto create(StockCreateCommand command) {
		
		if(stockRepository.find(command.getName()) != null) {
			throw new IllegalArgumentException("Já existe um estoque cadastrado com o nome informado.");
		}
		
		Stock stock = new Stock();
		stock.setId(UUID.randomUUID());
		stock.setName(command.getName().toUpperCase());
		
		stockRepository.save(stock); //gravando no PostGreSQL
		
		StockDto stockDto = new StockDto();
		stockDto.setId(stock.getId());
		stockDto.setName(stock.getName());
		
		stockDtoRepository.save(stockDto); //gravando no MongoDB
		
		
		return stockDto;
	}

	@Override
	public List<StockDto> findAll() {
		return stockDtoRepository.findAll();
	}

	@Override
	public StockDto findById(UUID id) {
		Optional<StockDto> stock = stockDtoRepository.findById(id);
		if(stock.isPresent()) {
			return stock.get();
		}
		return null;
	}

}
