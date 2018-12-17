package edu.ccc.pharma.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.repository.*;
import edu.ccc.pharma.users.*;
import edu.ccc.pharma.model.*;

@Service
public class LancamentoService {
	
	@Autowired
	LancamentoRepository LancamentoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public String criarLancamento(String idCliente) {
		Cliente cliente = procurarCliente(idCliente);
		String saida;
		ArrayList<Produto> carrinho = cliente.getCarrinho();
		int qtdItens = validarProdutos(carrinho).size();
		double valorTotal = calcularVenda(carrinho);
		Lancamento Lancamento = new Lancamento(qtdItens, valorTotal, carrinho);
		try {
			clienteRepository.delete(cliente);
			cliente.esvaziarCarrinho();
			clienteRepository.save(cliente);
			LancamentoRepository.save(Lancamento);
			saida = "Lancamento Criado!";
		} catch (Exception e) {
			saida = e.getMessage();
		}
		return saida;
	}

	private Cliente procurarCliente(String idCliente) {
		return clienteRepository.findByUsuario(idCliente);
	}

	private List<Produto> validarProdutos(List<Produto> produtos) {
		ArrayList<Produto> produtosValidos = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto.getSituacao())
				produtosValidos.add(produto);
		}
		return produtosValidos;
	}

	private double calcularVenda(List<Produto> produtos) {
		double saida = 0;
		for (Produto produto : produtos) {
			if (produto.getQuantidade() - 1 == 0) {
				saida += produto.getPreco() - (produto.getPreco() * produto.getDesconto());
				produto.subQuantidade();
				produto.setSituacao(false);
				produtoRepository.save(produto);
			} else if (produto.getQuantidade() > 0) {
				saida += produto.getPreco() - (produto.getPreco() * produto.getDesconto());
				produto.subQuantidade();
				produtoRepository.save(produto);
			}
		}
		return saida;
	}

	public List<Lancamento> listarLancamentos() {
		return LancamentoRepository.findAll();
	}

	public Lancamento procurarLancamento(int id) {
		return LancamentoRepository.findById(id);
	}

	public String criarLancamento(ArrayList<Produto> produtos) {
		String saida;
		int qtdItens = validarProdutos(produtos).size();
		double valorTotal = calcularVenda(produtos);
		Lancamento Lancamento = new Lancamento(qtdItens, valorTotal, produtos);
		try {
			LancamentoRepository.save(Lancamento);
			saida = "Lancamento Criado!";
		} catch (Exception e) {
			saida = e.getMessage();
		}
		return saida;
	}

	public String removerLancamento(int id) {
		String saida;
		try {
			LancamentoRepository.delete(LancamentoRepository.findById(id));
			ArrayList<Produto> produtos = LancamentoRepository.findById(id).getVenda();
			for (Produto p : produtos) {
				produtoRepository.delete(p);
				p.setQuantidade(p.getQuantidade() + 1);
				produtoRepository.save(p);				
			}
			saida = "Lancamento Apagado!";
		} catch (Exception e) {
			saida = e.getMessage();
		}
		return saida;
	}
	
	public ArrayList<Produto> procurarProdutos(ArrayList<String> codigos) {
		ArrayList<Produto> saida = new ArrayList<>();
		for (String codigo : codigos) {
			saida.add(produtoRepository.findByCodigo(codigo));
		}
		return saida;
	}
	
	
	

}
