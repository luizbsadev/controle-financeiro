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
    @Autowired
    JwtTokenService tokenService;
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

    public DadosTransacaoDTO salvarTransacao(DadosTransacaoDTO dados, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Conta conta = repositoryConta.findByUsuarioEmail(usuario);
        Transacao transacao = new Transacao(dados, conta);
        repositoryTransacao.save(transacao);

        return new DadosTransacaoDTO(transacao);
    }

    public List<DadosTransacaoDTO> listarTodos(String token) {
        List<DadosTransacaoDTO> lista = new ArrayList<>();
        String usuario = pegarUsuarioEmailDoToken(token);
        repositoryTransacao.findAllByContaUsuarioEmail(usuario).forEach(transacao -> {
            DadosTransacaoDTO dados = new DadosTransacaoDTO(transacao);
            lista.add(dados);
        });

        return lista;
    }

    public DadosTransacaoDTO deletarTransacao(Long id, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Transacao transacao = repositoryTransacao.findByIdAndContaUsuarioEmail(id, usuario);
        repositoryTransacao.delete(transacao);
        return new DadosTransacaoDTO(transacao);
    }

    public DadosTransacaoDTO alterarTransacao(Long id, DadosTransacaoDTO dadosNovos, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Transacao transacaoAntiga = repositoryTransacao.findByIdAndContaUsuarioEmail(id, usuario);
        Transacao transacao = alterarInformacoesTransacao(transacaoAntiga, dadosNovos);
        return new DadosTransacaoDTO(transacao);
    }

    public DadosTransacaoDTO listarPorId(Long id) {
        return new DadosTransacaoDTO(repositoryTransacao.getReferenceById(id));
    }

    public String pegarUsuarioEmailDoToken(String token){
        return tokenService.getSubjectFromToken(token.replace("Bearer ", ""));
    }
}
