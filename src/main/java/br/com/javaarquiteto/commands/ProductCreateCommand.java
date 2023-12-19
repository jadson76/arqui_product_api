package br.com.javaarquiteto.commands;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductCreateCommand {
		
	private String name;
	private Double price;
	private Integer quantity;
	private UUID stockId;

}
