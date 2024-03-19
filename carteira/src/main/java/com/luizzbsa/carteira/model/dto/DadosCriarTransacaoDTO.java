package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.enums.TipoTransacao;

import java.math.BigDecimal;

public record DadosCriarTransacaoDTO(
        String descricao,
        String categoria,
        TipoTransacao tipoTransacao
    ) {
}
