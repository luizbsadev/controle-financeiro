package com.luizzbsa.carteira.model.repository;

import com.luizzbsa.carteira.model.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoesDAO extends JpaRepository<Transacao, Long> {
    List<Transacao> findAllByContaUsuarioEmail(String email);

    Transacao findByIdAndContaUsuarioEmail(Long id, String email);
}
