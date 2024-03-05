package com.luizzbsa.carteira.model.repository;

import com.luizzbsa.carteira.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
}
