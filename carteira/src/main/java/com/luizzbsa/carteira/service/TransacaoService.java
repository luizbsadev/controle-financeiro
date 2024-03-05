package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.entity.Transacao;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    public Transacao alterarInformacoesTransacao(Transacao transacaoVelha, Transacao transacaoNova){
        if(transacaoNova.getCategoria().isEmpty()){
            transacaoVelha.setCategoria(transacaoNova.getCategoria());
        }
        if(transacaoNova.getTipoTransacao() != null){
            transacaoVelha.setTipoTransacao(transacaoNova.getTipoTransacao());
        }
        if(transacaoNova.getValor() == null){
            transacaoVelha.setValor(transacaoNova.getValor());
        }
        if(transacaoNova.getDescricao().isEmpty()){
            transacaoVelha.setDescricao(transacaoNova.getDescricao());
        }

        return transacaoVelha;
    }
}
