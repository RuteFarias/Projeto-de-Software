package edu.ccc.pharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.repository.AdministradorRepository;
import edu.ccc.pharma.users.Administrador;


@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	public Boolean login(String senha) {
		Boolean saida = false;
		String senhaAdmin = administradorRepository.getAdmin();
		if (senha.equals(senhaAdmin))
			saida = true;
		return saida;
	}
	
	public String criaAdmin(String username, String senha) {
		Administrador admin = new Administrador(username,senha);
		administradorRepository.save(admin);
		return "Admin Cadastrado";
	}
	
	
	public List<Administrador> get() {
		return this.administradorRepository.findAll();
	}


}
