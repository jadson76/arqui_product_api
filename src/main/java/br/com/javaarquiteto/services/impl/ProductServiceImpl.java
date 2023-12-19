package br.com.javaarquiteto.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javaarquiteto.commands.ProductCreateCommand;
import br.com.javaarquiteto.commands.ProductDeleteCommand;
import br.com.javaarquiteto.commands.ProductUpdateCommand;
import br.com.javaarquiteto.dtos.ProductDto;
import br.com.javaarquiteto.dtos.StockDto;
import br.com.javaarquiteto.entities.Product;
import br.com.javaarquiteto.entities.Stock;
import br.com.javaarquiteto.repositories.mongodb.ProductDtoRepository;
import br.com.javaarquiteto.repositories.postgresql.ProductRepository;
import br.com.javaarquiteto.repositories.postgresql.StockRepository;
import br.com.javaarquiteto.services.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	ProductDtoRepository productDtoRepository;

	@Override
	public ProductDto create(ProductCreateCommand command) {
		
		Stock stock = stockRepository.find(command.getStockId());
		if(stock == null)
			throw new IllegalArgumentException("Estoque não encontrado.");
		
		ProductDto prod = productDtoRepository.findByName(command.getName());
		
		if(prod != null)
			throw new IllegalArgumentException("Já existe produto com este nome.");
		
		Product product = new Product();
		product.setId(UUID.randomUUID());
		product.setName(command.getName());
		product.setPrice(new BigDecimal(command.getPrice()));
		product.setQuantity(command.getQuantity());
		product.setStock(stock);
		
		productRepository.save(product);
		
		ProductDto productDto = new ProductDto();
		productDto.setStockDto(new StockDto());
		
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice().doubleValue());
		productDto.setQuantity(product.getQuantity());
		productDto.setTotal(product.getQuantity() * product.getPrice().doubleValue());
		productDto.getStockDto().setId(stock.getId());
		productDto.getStockDto().setName(stock.getName());	
		
		productDtoRepository.save(productDto);
		
		return productDto;

	}

	@Override
	public ProductDto update(ProductUpdateCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto delete(ProductDeleteCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> findByStock(UUID stockId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
