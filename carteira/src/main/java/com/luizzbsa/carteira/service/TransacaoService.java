package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.entity.dto.DadosTransacaoSalvarDTO;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import com.luizzbsa.carteira.model.repository.TransacoesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    TransacoesDAO repositoryTransacao;
    @Autowired
    ContaDAO repositoryConta;
    public Transacao alterarInformacoesTransacao(Transacao transacaoVelha, Transacao transacaoNova){
        if(transacaoNova.getCategoria() != null){
            transacaoVelha.setCategoria(transacaoNova.getCategoria());
        }
        if(transacaoNova.getTipoTransacao() != null){
            transacaoVelha.setTipoTransacao(transacaoNova.getTipoTransacao());
        }
        if(transacaoNova.getValor() != null){
            transacaoVelha.setValor(transacaoNova.getValor());
        }
        if(transacaoNova.getDescricao() != null){
            transacaoVelha.setDescricao(transacaoNova.getDescricao());
        }

        return transacaoVelha;
    }

    public void salvarTransacao(DadosTransacaoSalvarDTO dados) {
        Conta conta = repositoryConta.getReferenceById(dados.contaId());
        Transacao transacao = new Transacao(dados, conta);
        repositoryTransacao.save(transacao);
    }
}
