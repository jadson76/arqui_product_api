package br.com.javaarquiteto.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaarquiteto.commands.ProductCreateCommand;
import br.com.javaarquiteto.dtos.ProductDto;
import br.com.javaarquiteto.services.interfaces.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {
	
	@Autowired ProductService productService;
	
	@PostMapping
	public ProductDto post(@RequestBody ProductCreateCommand command) {
		return productService.create(command);

	}
	
	@PutMapping
	public void put() {
		// TODO Implementar a consulta de estoques
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") UUID id) {
		// TODO Implementar a consulta de estoque por ID
	}
	
	@GetMapping("{stockId}")
	public void getByStock(@PathVariable("stockID") UUID id) {
		// TODO Implementar a consulta de estoque por ID
	}
	
	@GetMapping("{id}")
	public void GetById(UUID id) {
		// TODO Implementar a consulta de estoque por ID
	}


}
