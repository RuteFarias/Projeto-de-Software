package edu.ccc.pharma.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ccc.pharma.model.Produto;

/**
 * 
 * @author RuteFarias
 * Produto Repository
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	
	Produto findByNome(@Param("nome") String nome);

	Produto findByCodigo(@Param("codigo") String codigo);

	
	@Modifying
	@Transactional
	@Query("update Produto p set p.preco = ?2 where p.codigo = ?1")
	void mudarPreco(String codigo, Double preco);
	
	@Modifying
	@Transactional
	@Query("update Produto p set p.desconto = ?2 where p.categoria = ?1")
	void atribuirDesconto(String categoria, Integer desconto);

}
