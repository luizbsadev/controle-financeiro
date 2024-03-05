package com.luizzbsa.carteira.model.repository;

import com.luizzbsa.carteira.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaDAO extends JpaRepository<Conta, Long> {
}
