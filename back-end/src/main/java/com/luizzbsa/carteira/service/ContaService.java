package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.dto.DadosContaDTO;
import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.Usuario;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import com.luizzbsa.carteira.model.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ContaService {

    ContaDAO repositoryConta;
    UsuarioDAO repositoryUsuario;

    @Autowired
    public ContaService(ContaDAO repositoryConta, UsuarioDAO repositoryUsuario) {
        this.repositoryConta = repositoryConta;
        this.repositoryUsuario = repositoryUsuario;
    }


    public DadosContaDTO criarConta(Usuario usuario) {
        Conta conta = new Conta(usuario);
        repositoryConta.save(conta);
        return new DadosContaDTO(conta);
    }

    public void atualizarSaldo(Conta conta){
        conta.setSaldo(new BigDecimal(0));
        conta.setCredito(new BigDecimal(0));
        conta.setDebito(new BigDecimal(0));

        conta.getTransacoes().forEach((transacao) -> {
            switch (transacao.getTipoTransacao()){
                case CREDITO -> conta.somarValor(transacao.getValor());
                case DEBITO-> conta.subtrairValor(transacao.getValor());
                }
        });
    }
}
