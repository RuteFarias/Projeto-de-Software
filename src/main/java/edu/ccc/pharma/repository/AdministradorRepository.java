package edu.ccc.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ccc.pharma.users.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
	
	public Administrador findByUsername(@Param("usuario") String usuario);
	
	@Query("select a.senha from Admin a where a.username='adm'")
	public String getAdmin();
	

}
