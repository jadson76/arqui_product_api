package br.com.javaarquiteto.repositories.mongodb;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.javaarquiteto.dtos.ProductDto;

@Repository
public interface ProductDtoRepository extends MongoRepository<ProductDto, UUID> {
	
	@Query(value = "{name:?0}" ) 
	ProductDto findByName(String name);

}
