package br.com.javaarquiteto.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_stock")
public class Stock {
	
	@Id
	@Column
	private UUID id;
	
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "stock")
	private List<Product> produtcs;
	
	

}
