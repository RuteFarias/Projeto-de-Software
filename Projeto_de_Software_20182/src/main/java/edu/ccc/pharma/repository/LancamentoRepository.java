package edu.ccc.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import edu.ccc.pharma.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, String> {

	public Lancamento findById(@Param("id") Integer id);
}
