package br.com.javaarquiteto.dtos;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "stocks")
public class StockDto {
	
	@Id
	private UUID id;	
	
	private String name;	
	

}
