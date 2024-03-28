package com.luizzbsa.carteira.model.entity;


import com.luizzbsa.carteira.infra.SecurityConfiguration;
import com.luizzbsa.carteira.model.dto.CriarUsuarioDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;

    public Usuario(){}

    public Usuario(CriarUsuarioDTO dados, SecurityConfiguration securityConfiguration){
        this.email = dados.email();
        this.senha = securityConfiguration.passwordEncoder().encode(dados.senha());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
