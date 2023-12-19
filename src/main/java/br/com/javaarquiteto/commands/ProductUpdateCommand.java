package br.com.javaarquiteto.commands;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductUpdateCommand {
	
	private UUID Id;
	private String name;
	private Double price;
	private Integer quantity;
	private UUID stockId;

}
