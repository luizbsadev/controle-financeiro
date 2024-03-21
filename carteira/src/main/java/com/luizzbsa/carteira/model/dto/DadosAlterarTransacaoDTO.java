package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.enums.TipoTransacao;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DadosAlterarTransacaoDTO(
        @Positive
        BigDecimal valor,
        String categoria,
        TipoTransacao tipoTransacao,
        String descricao) {
    public DadosAlterarTransacaoDTO(Transacao transacao){
        this(transacao.getValor(), transacao.getCategoria(), transacao.getTipoTransacao(), transacao.getDescricao());
    }
}
