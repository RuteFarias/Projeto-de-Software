package edu.ccc.pharma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ccc.pharma.model.Produto;

/**
 * 
 * @author RuteFarias
 * Produto Repository
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	public Optional<Produto> findById(String id);

}
