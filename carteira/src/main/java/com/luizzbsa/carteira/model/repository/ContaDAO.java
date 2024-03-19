package com.luizzbsa.carteira.model.repository;

import com.luizzbsa.carteira.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaDAO extends JpaRepository<Conta, Long> {

}
