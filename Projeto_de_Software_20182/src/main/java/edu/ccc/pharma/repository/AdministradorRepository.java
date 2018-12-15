package edu.ccc.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import edu.ccc.pharma.users.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
	
	public Administrador findByUsuario(@Param("usuario") String usuario);
	


}
