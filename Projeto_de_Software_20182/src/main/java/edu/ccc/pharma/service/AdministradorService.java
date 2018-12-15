package edu.ccc.pharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.repository.AdministradorRepository;
import edu.ccc.pharma.users.Administrador;


@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	public String login(String usuario, String senha) {
		String saida;
		Administrador admin = administradorRepository.findByUsuario(usuario);
		if (admin == null) {
			saida = "Falha: adm invalido";
		}
		else {
			if (senha.equals(admin.getSenha())) {
				saida = "Sucesso!";
			}
			else {
				saida = "Erro: senha invalida";
			}
		}
		return saida;
	}


}
