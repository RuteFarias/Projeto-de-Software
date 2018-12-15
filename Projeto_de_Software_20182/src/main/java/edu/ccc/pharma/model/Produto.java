package edu.ccc.pharma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

enum CategoriaProduto {
	medicamentos, higiene,cosmesticos, alimentos; 
}

/**
 * 
 * @author RuteFarias
 * Produto
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column
    private String nome;

    @Column
    private String codigoBarras;
    
    @Column 
    private String fabricante;
    
    @Column 
    private String situacao;
    
    @Column
    private CategoriaProduto categoria;

    public Produto() {}

    public Produto(String id, String nome, String codigoBarras, String fabricante, String situacao, CategoriaProduto categoria) {
        super();
        
        this.id = id;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.fabricante = fabricante;
        this.situacao = situacao;
        this.categoria = categoria;
    }
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}
    
    

   

}
	
	
	


