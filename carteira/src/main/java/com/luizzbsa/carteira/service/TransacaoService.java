package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.dto.*;
import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import com.luizzbsa.carteira.model.repository.TransacoesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private TransacoesDAO repositoryTransacao;
    private ContaDAO repositoryConta;
    private JwtTokenService tokenService;
    private ContaService contaService;

    @Autowired
    public TransacaoService(TransacoesDAO transacaoDAO, ContaDAO contaDAO, JwtTokenService jwtTokenService, ContaService contaService){
        this.repositoryTransacao = transacaoDAO;
        this.repositoryConta = contaDAO;
        this.tokenService = jwtTokenService;
        this.contaService = contaService;
    }


    public Transacao alterarInformacoesTransacao(Transacao transacaoVelha, DadosAlterarTransacaoDTO transacaoNova){
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

    public DadosTransacaoDTO salvarTransacao(DadosCriarTransacaoDTO dados, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Conta conta = repositoryConta.findByUsuarioEmail(usuario);
        Transacao transacao = new Transacao(dados, conta);
        repositoryTransacao.save(transacao);
        contaService.atualizarSaldo(conta);


        return new DadosTransacaoDTO(transacao);
    }

    public List<DadosListarTransacaoDTO> listarTodos(String token) {
        List<DadosListarTransacaoDTO> lista = new ArrayList<>();
        String usuario = pegarUsuarioEmailDoToken(token);
        repositoryTransacao.findAllByContaUsuarioEmail(usuario).forEach(transacao -> {
            DadosListarTransacaoDTO dados = new DadosListarTransacaoDTO(transacao);
            lista.add(dados);
        });

        return lista;
    }

    public DadosDeletarTransacaoDTO deletarTransacao(Long id, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Transacao transacao = repositoryTransacao.findByIdAndContaUsuarioEmail(id, usuario);
        repositoryTransacao.delete(transacao);
        contaService.atualizarSaldo(transacao.getConta());
        return new DadosDeletarTransacaoDTO(transacao);
    }

    public DadosAlterarTransacaoDTO alterarTransacao(Long id, DadosAlterarTransacaoDTO dadosNovos, String token) {
        String usuario = pegarUsuarioEmailDoToken(token);
        Transacao transacaoAntiga = repositoryTransacao.findByIdAndContaUsuarioEmail(id, usuario);
        Transacao transacao = alterarInformacoesTransacao(transacaoAntiga, dadosNovos);
        contaService.atualizarSaldo(transacao.getConta());
        return new DadosAlterarTransacaoDTO(transacao);
    }

    public DadosTransacaoDTO listarPorId(Long id) {
        return new DadosTransacaoDTO(repositoryTransacao.getReferenceById(id));
    }

    public String pegarUsuarioEmailDoToken(String token){
        return tokenService.getSubjectFromToken(token.replace("Bearer ", ""));
    }
}
