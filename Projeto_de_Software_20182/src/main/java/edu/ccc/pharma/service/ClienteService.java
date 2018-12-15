package edu.ccc.pharma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.repository.ClienteRepository;
import edu.ccc.pharma.users.Cliente;

@Service
public class ClienteService {
	
	 @Autowired
	    ClienteRepository clienteRepository;

	    public List<Cliente> getAll() {
	        return this.clienteRepository.findAll();
	    }

	    public Cliente cadastrarCliente(Cliente cliente) throws Exception {
	         if (!verificarUsuario(cliente.getUsuario())) {
	        	 this.clienteRepository.save(cliente);
	        	 return cliente;
	         } else {
	        	 throw new Exception("Erro: cadastro ja existe!");
	         }
	    }

	    public String excluirCliente(String usuario) throws Exception {
	    	if (verificarUsuario(usuario)) {
	    		this.clienteRepository.deleteById(usuario);
	    		return "Sucesso!";
	    	} else {
	    		throw new Exception("Cliente nao existe!");
	    	}
	    }
	    
	    public String login(String usuario, String senha) {
			String saida;
			if (!verificarUsuario(usuario))
				saida = "Falha: cliente invalido!";
			else {
				Cliente cliente = clienteRepository.findByUsuario(usuario);
				if (senha.equals(cliente.getSenha()))
					saida = "Sucesso!";
				else
					saida = "Falha: senha invalida!";
			}
			return saida;
		}
	    
		public String adicionarNoCarrinho(String usuario, ArrayList<Produto> carrinho) {
			Cliente cliente = clienteRepository.findByUsuario(usuario);
			String saida;
			try {
				clienteRepository.delete(cliente);
				cliente.adicionarNoCarrinho(carrinho);			
				clienteRepository.save(cliente);
				saida = "Carrinho Atualizado";
			} catch (Exception e) {
				saida = e.getMessage();
			}
			return saida;
		}
		
		public String removerDoCarrinho(String usuario, Produto produto) {
			Cliente cliente = clienteRepository.findByUsuario(usuario);
			String saida;
			try {
				clienteRepository.delete(cliente);
				cliente.removerDoCarrinho(produto);			
				clienteRepository.save(cliente);
				saida = "Carrinho Atualizado";
			} catch (Exception e) {
				saida = e.getMessage();
			}
			return saida;
		}
	    
	    public boolean verificarUsuario(String usuario) {
	    	return this.clienteRepository.existsById(usuario);
	    }

		
	 
	
	
	

}
