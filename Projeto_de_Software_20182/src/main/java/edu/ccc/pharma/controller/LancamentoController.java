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

import edu.ccc.pharma.model.Lancamento;
import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.service.*;

@CrossOrigin(value = "*")
@RestController

public class LancamentoController {
	
	@Autowired
	LancamentoService LancamentoService;
	
	@RequestMapping(value = "/Lancamento/novoLancamento/{idCliente}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String criarLancamento(@PathVariable String idCliente) throws Exception {
		return this.LancamentoService.criarLancamento(idCliente);
	}
	
	@RequestMapping(value = "/Lancamento/novoLancamento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String criarLancamentoAdmin(@RequestBody ArrayList<String> codigos) throws Exception {
		ArrayList<Produto> produtos = this.LancamentoService.procurarProdutos(codigos);
		return this.LancamentoService.criarLancamento(produtos);
	}
	
	@RequestMapping(value = "/Lancamento/listarLancamentos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Lancamento> listarLancamentos() {
		return this.LancamentoService.listarLancamentos();
	}
	
	@RequestMapping(value = "/Lancamento/pesquisarLancamento/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Lancamento procurarLancamento(@PathVariable Integer id) {
		return this.LancamentoService.procurarLancamento(id);
	}
	
	@RequestMapping(value = "/Lancamento/removerLancamento/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public String removerLancamento(@PathVariable Integer id) {
		return this.LancamentoService.removerLancamento(id);
	}

}
