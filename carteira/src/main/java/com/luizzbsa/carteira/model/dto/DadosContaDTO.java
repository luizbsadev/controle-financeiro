package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.entity.Conta;

import java.math.BigDecimal;

public record DadosContaDTO(Long id, Long usuario_id, BigDecimal saldo, BigDecimal debito, BigDecimal credito) {

    public DadosContaDTO(Conta conta){
        this(conta.getId(), conta.getUsuario().getId(), conta.getSaldo(), conta.getDebito(), conta.getCredito());
    }
}
