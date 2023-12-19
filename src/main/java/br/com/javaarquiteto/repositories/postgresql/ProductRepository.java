package br.com.javaarquiteto.repositories.postgresql;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.javaarquiteto.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	@Query("SELECT p FROM Product p JOIN p.stock s WHERE p.id = :id")
	Product find(@Param("id") UUID id);
	
	@Query("SELECT p FROM Product p JOIN p.stock s WHERE s.id = :stockId")
	List<Product> findByStock(@Param("stockId") UUID stockId);
}



