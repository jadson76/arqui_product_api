package br.com.javaarquiteto.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.javaarquiteto.commands.ProductCreateCommand;
import br.com.javaarquiteto.commands.ProductDeleteCommand;
import br.com.javaarquiteto.commands.ProductUpdateCommand;
import br.com.javaarquiteto.dtos.ProductDto;

public interface ProductService {
	
	ProductDto create(ProductCreateCommand command);
	
	ProductDto update(ProductUpdateCommand command);
	
	ProductDto delete(ProductDeleteCommand command);
	
	List<ProductDto> findByStock(UUID stockId);
	
	ProductDto findById(UUID id);

}
