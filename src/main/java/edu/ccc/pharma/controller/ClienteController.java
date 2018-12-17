package edu.ccc.pharma.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.service.ClienteService;
import edu.ccc.pharma.users.Cliente;


@RestController
@CrossOrigin(value = "*")

public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Cliente> getCliente() {
		return clienteService.getAll();
	}
	
	@RequestMapping(value = "/clientes/cadastro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Cliente addCliente(@RequestBody Cliente cliente) throws Exception {
		return this.clienteService.cadastrarCliente(cliente);
	}
	
	@RequestMapping(value = "/clientes/excluir/{usuario}", method = RequestMethod.DELETE)
	public String excluirCliente(@PathVariable String usuario) throws Exception {
		return this.clienteService.excluirCliente(usuario);
	}
	
	@RequestMapping(value = "/clientes/cadastrar/validacao/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public boolean validaUsuario(@PathVariable String usuario) {
		return !(this.clienteService.verificarUsuario(usuario));
	}
	
	@RequestMapping(value = "/clientes/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String login(@RequestBody String usuario, @RequestBody String senha) throws Exception {
		return this.clienteService.login(usuario, senha);
	}
	
	@RequestMapping(value = "/clientes/addProduto/{usuario}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String updateAdicionaCarrinho(@PathVariable String usuario, @RequestBody ArrayList<Produto> carrinho) {
		return this.clienteService.adicionarNoCarrinho(usuario, carrinho);
	}
	
	@RequestMapping(value = "/clientes/removeProduto/{usuario}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String updateRemoveCarrinho(@PathVariable String usuario, @RequestBody Produto produto) {
		return this.clienteService.removerDoCarrinho(usuario, produto);
	}

	
	
	
	
	

}
