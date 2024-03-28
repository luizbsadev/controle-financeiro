package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.enums.TipoTransacao;

import java.math.BigDecimal;

public record DadosDeletarTransacaoDTO(Long id, BigDecimal valor, TipoTransacao tipoTransacao) {
    public DadosDeletarTransacaoDTO(Transacao transacao){
        this(transacao.getId(),transacao.getValor(), transacao.getTipoTransacao());
    }
}
