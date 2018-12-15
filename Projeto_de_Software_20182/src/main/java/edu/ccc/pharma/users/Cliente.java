package edu.ccc.pharma.users;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.ccc.pharma.model.Produto;


@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nome")
    @NotNull(message = "Entrada invalida!")
    @NotEmpty(message = "Campo vazio!")
    private String nome;

    @Column(name = "senha")
    @NotNull(message = "Entrada invalida!")
    @NotEmpty(message = "Campo vazio!")
    private String senha;
    
    private ArrayList<Produto> carrinho = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String usuario, String nome, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
    }
    
     public ArrayList<Produto> getCarrinho() {
         return this.carrinho;
     }
    
     public void setCarrinho(ArrayList<Produto> carrinho) {
         this.carrinho = carrinho;
     }

    public String getUsuario() {
        return this.usuario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void adicionarNoCarrinho(ArrayList<Produto> produtos) {
		for (Produto produto : produtos) {
			this.carrinho.add(produto);
		}
	}
    
    public void removerDoCarrinho(Produto produto) {
		this.carrinho.remove(produto);		
	}

	public void esvaziarCarrinho() {
		this.carrinho = new ArrayList<>();		
	}
    
}

