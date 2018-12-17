package edu.ccc.pharma.repository;
import edu.ccc.pharma.users.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface ClienteRepository extends JpaRepository<Cliente, String> {

	public Cliente findByUsuario(@Param("usuario") String usuario);
	}

