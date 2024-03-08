package com.luizzbsa.carteira.model.dto;

import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.entity.enums.TipoTransacao;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public record DadosTransacaoDTO(

        Long id,
        Long contaId,
        BigDecimal valor,
        String descricao,
        String categoria,

         TipoTransacao tipoTransacao) {


        public DadosTransacaoDTO(Transacao transacao){
            this(
                    transacao.getId(),
                    transacao.getConta().getId(),
                    transacao.getValor(),
                    transacao.getDescricao(),
                    transacao.getCategoria(),
                    transacao.getTipoTransacao());

        }








}

