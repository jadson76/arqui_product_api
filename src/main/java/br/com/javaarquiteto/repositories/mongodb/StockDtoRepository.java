package br.com.javaarquiteto.repositories.mongodb;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.javaarquiteto.dtos.StockDto;

@Repository
public interface StockDtoRepository extends MongoRepository<StockDto, UUID>{

}
