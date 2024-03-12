package com.luizzbsa.carteira.model.repository;

import com.luizzbsa.carteira.model.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesDAO extends JpaRepository<Transacao, Long> {
}
