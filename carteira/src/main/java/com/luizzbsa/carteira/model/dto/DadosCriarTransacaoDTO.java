package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.enums.TipoTransacao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DadosCriarTransacaoDTO(

        @NotBlank
        @Positive
        BigDecimal valor,
        String descricao,

        String categoria,
        @NotNull
        TipoTransacao tipoTransacao
    ) {
}
