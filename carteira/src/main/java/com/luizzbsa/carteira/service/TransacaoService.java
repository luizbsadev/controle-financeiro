package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.dto.DadosTransacaoDTO;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import com.luizzbsa.carteira.model.repository.TransacoesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    TransacoesDAO repositoryTransacao;
    @Autowired
    ContaDAO repositoryConta;
    public Transacao alterarInformacoesTransacao(Transacao transacaoVelha, DadosTransacaoDTO transacaoNova){
        if(transacaoNova.categoria() != null){
            transacaoVelha.setCategoria(transacaoNova.categoria());
        }
        if(transacaoNova.tipoTransacao() != null){
            transacaoVelha.setTipoTransacao(transacaoNova.tipoTransacao());
        }
        if(transacaoNova.valor() != null){
            transacaoVelha.setValor(transacaoNova.valor());
        }
        if(transacaoNova.descricao() != null){
            transacaoVelha.setDescricao(transacaoNova.descricao());
        }

        return transacaoVelha;
    }

    public DadosTransacaoDTO salvarTransacao(DadosTransacaoDTO dados) {
        Conta conta = repositoryConta.getReferenceById(dados.contaId());
        Transacao transacao = new Transacao(dados, conta);
        repositoryTransacao.save(transacao);

        return new DadosTransacaoDTO(transacao);
    }

    public List<DadosTransacaoDTO> listarTodos() {
        List<DadosTransacaoDTO> lista = new ArrayList<>();
        repositoryTransacao.findAll().forEach(transacao -> {
            DadosTransacaoDTO dados = new DadosTransacaoDTO(transacao);
            lista.add(dados);
        });

        return lista;
    }

    public DadosTransacaoDTO deletarTransacao(Long id) {
        Transacao transacao = repositoryTransacao.getReferenceById(id);
        repositoryTransacao.delete(transacao);
        return new DadosTransacaoDTO(transacao);
    }

    public DadosTransacaoDTO alterarTransacao(Long id, DadosTransacaoDTO dadosNovos) {
        Transacao transacaoAntiga = repositoryTransacao.getReferenceById(id);
        Transacao transacao = alterarInformacoesTransacao(transacaoAntiga, dadosNovos);
        return new DadosTransacaoDTO(transacao);
    }

    public DadosTransacaoDTO listarPorId(Long id) {
        return new DadosTransacaoDTO(repositoryTransacao.getReferenceById(id));
    }
}
