package com.luizzbsa.carteira.model.entity.dto;

import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.enums.TipoTransacao;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public record DadosTransacaoSalvarDTO(
        Long contaId,
        BigDecimal valor,
        String descricao,
        String categoria,

         TipoTransacao tipoTransacao) {


}

