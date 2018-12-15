package edu.ccc.pharma.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
public class Administrador {

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nome")
    @NotNull(message = "Entrada invalida!")
    @NotEmpty(message = "Campo vazio!")
    private String nome;


    @Column(name = "senha")
    @NotNull(message = "Entrada invalida")
    @NotEmpty(message = "Campo vazio!")
    private String senha;

    public Administrador() {

    }

    public Administrador(String usuario, String nome, String senha) {
    	 this.usuario = "RootFarias";
         this.nome = "Rute";
         this.senha = "116211043";
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

}