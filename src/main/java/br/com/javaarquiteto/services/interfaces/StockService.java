package br.com.javaarquiteto.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.javaarquiteto.commands.StockCreateCommand;
import br.com.javaarquiteto.dtos.StockDto;

public interface StockService {
	
	StockDto create(StockCreateCommand command);
	
	List<StockDto> findAll();
	
	StockDto findById(UUID id);

}
