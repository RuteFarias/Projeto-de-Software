package edu.ccc.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.service.ProdutoService;

/**
 * 
 * @author RuteFarias e Yally Galdino
 * ProdutoController
 *
 */

@RestController
@RequestMapping("/produto")

public class ProdutoController {
	@Autowired
	ProdutoService produtoService;

	@RequestMapping(value = "/produtos/orderbyprice", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getprodutosperPrice() {
		return this.produtoService.orderByPrice();
	}
	
	@RequestMapping(value = "/produtos/orderbyname", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getprodutosperName() {
		return this.produtoService.orderByNome();
	}
	
	@RequestMapping(value = "/produtos/orderbycategory", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getprodutosByCategory() {
		return this.produtoService.orderByCategory();
	}
	
	@RequestMapping(value = "/produtos/crud/{codigo}", method = RequestMethod.DELETE)
	public Produto deleteproduto(@PathVariable String codigo) {
		return this.produtoService.excluirProduto(codigo);
	}
	
	@RequestMapping(value = "/produtos/crud", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Produto addproduto(@RequestBody Produto produto) throws Exception {
		return this.produtoService.inserirProduto(produto);
	}
	
	@RequestMapping(value = "/produtos/crud/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public Double serPrice(@PathVariable String codigo, @RequestBody Double preco) throws Exception {
		return this.produtoService.mudarPreco(codigo, preco);
	}

	@RequestMapping(value = "/produtos/desconto/{categoria}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public void atribuirDesconto(@PathVariable String categoria, @RequestBody Integer desconto) {
		this.produtoService.atribuirDesconto(categoria, desconto);
	}
		
	@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Produto> getprodutos() {
		return this.produtoService.getAll();
	}

}
