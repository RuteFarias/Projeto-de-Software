package edu.ccc.pharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.repository.ProdutoRepository;

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
        return this.produtoRepository.findAll();
    }

    public Produto findById(String id) {
        return this.produtoRepository.findById(id).get();
    }

    public Produto inserirProduto(Produto produto) {
        return this.produtoRepository.save(produto);
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


}
