package edu.ccc.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ccc.pharma.model.Produto;
import edu.ccc.pharma.service.ProdutoService;

/**
 * 
 * @author RuteFarias
 * ProdutoController
 *
 */

@RestController
@RequestMapping("/produto")

public class ProdutoController {
	@Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProduto() {
        return this.produtoService.getAll();
    }
    
    @GetMapping(value="/{id}")
    public Produto findById(@PathVariable(value = "id") String id) {
        return this.produtoService.findById(id);
    }

    @PostMapping
    public Produto inserirProduto(@RequestBody Produto produto) {
        return this.produtoService.inserirProduto(produto);
    }
        

    @PutMapping(value="/{id}")
    public Produto atualizarProduto(@PathVariable String id, @RequestBody Produto produto) {
        return this.produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping(value="/{id}")
    public Produto excluirProduto(@PathVariable String id, @RequestBody Produto produto) {
        return this.produtoService.excluirProduto(id, produto);
    }
 
	
	

}
