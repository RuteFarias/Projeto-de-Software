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

    @Column(name = "senha")
    @NotNull(message = "Entrada invalida")
    @NotEmpty(message = "Campo vazio!")
    private String senha;

    public Administrador() {

    }

    public Administrador(String usuario, String senha) {
    	 this.usuario = usuario;
         this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

}