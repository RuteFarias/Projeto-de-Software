package edu.ccc.pharma.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.repository.ProdutoRepository;
import edu.ccc.pharma.users.Cliente;
import edu.ccc.pharma.util.ComparadorCategorias;
import edu.ccc.pharma.util.ComparadorNomes;
import edu.ccc.pharma.util.ComparadorPrecos;

/**
 * 
 * @author RuteFarias
 * ProdutoService
 *
 */

@Service
public class ProdutoService {
	
	@Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
    	
    	List<Produto> saida = new ArrayList<>();
    	for (Produto produto : this.produtoRepository.findAll()) {
			if(!produto.getSituacao())
				produto.setPreco(00.00);
			saida.add(produto);
		}
        return saida;
        
    }

    public Produto inserirProduto(Produto produto) throws Exception{
    	if (!verificarCodigo(produto.getCodigoBarras())) {
    		this.produtoRepository.save(produto);
    		return produto;
    	} else {
    		throw new Exception("Produto ja cadastrado!");
    	}
        
    }

    public Produto excluirProduto(String id, Produto produto) {
        if (id.equals(produto.getId())) {
            this.produtoRepository.deleteById(id);
            return produto;
        } else {
            return null;
        }
    }

    public Produto atualizarProduto(String id, Produto produto) {
        if (id.equals(produto.getId())) {
            return this.produtoRepository.save(produto);
        } else {
            return null;
        }
    }
    
    public boolean verificarCodigo(String codigo) {
    	return this.produtoRepository.existsById(codigo);
    }
    
    public Produto findByNome(String nome) {
        return this.produtoRepository.findByNome(nome);
    }
    public Double mudarPreco(String codigo, Double preco) throws Exception {
    	if (verificarCodigo(codigo) && preco >= 0) {
    		this.produtoRepository.mudarPreco(codigo, preco);
    		return preco;
    	} else {
    		throw new Exception("Produto não cadastrado ou preço inválido!");
    	}
    }
    
    public Produto findByCodigo(String codigo) {
    	return this.produtoRepository.findByCodigo(codigo);
    }

    public Boolean getDisponibilidadeProduto(String nome) {
        Produto p = this.produtoRepository.findByNome(nome);
        return p.getSituacao();
    }

    public Double getPrecoProduto(String nome) {
        Produto p = this.produtoRepository.findByNome(nome);
        return p.getPreco();
    }
    
    public void setPrecoProduto(String nome, Double preco) {
        Produto p = this.produtoRepository.findByNome(nome);
        p.setPreco(preco);
    }
    
    public Produto excluirProduto(String codigo) {
    	Produto p = this.produtoRepository.findByCodigo(codigo);
    	this.produtoRepository.delete(p);
    	return p;
    }
    
    public List<Produto> orderByNome() {
        List<Produto> lista = this.getAll();
        Collections.sort(lista, new ComparadorNomes());
        return lista;
    }

    public List<Produto> orderByPrice() {
        List<Produto> list = this.getAll();
        Collections.sort(list, new ComparadorPrecos());
        return list;
    }
    
    public List<Produto> orderByCategory() {
    	List<Produto> list = this.getAll();
    	Collections.sort(list, new ComparadorCategorias());
    	return list;
    }
    
    public void atribuirDesconto(String categoria, Integer desconto) {
		this.produtoRepository.atribuirDesconto(categoria, desconto);
	}
    
    public void addCarrinho(Cliente cliente, Produto produto) {
    	cliente.getCarrinho().add(produto);
    }



}
