package edu.ccc.pharma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



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

	@Column(name = "nome")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private String nome;

    @Column(name = "codigoBarras")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private String codigoBarras;
    
    @Column(name = "fabricante")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private String fabricante;
    
    @Column(name = "situacao")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private Boolean situacao;
    
    @Column(name = "categoria")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private String categoria;
    
    @Column(name = "quantidade")
    @NotNull(message = "Entrada invalida!")
	@NotEmpty(message = "Campo vazio!")
    private int quantidade;
    
    @Column(name = "desconto")
	private Integer desconto = 0;
    
    @Column(name = "preco")
	private Double preco;

    public Produto() {}

    public Produto(String id, String nome, String codigoBarras, String fabricante, String categoria, int quantidade, double preco) {
        super();
        
        this.id = id;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void subQuantidade() {
		this.quantidade = this.quantidade - 1;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

    

   

}
	
	
	


