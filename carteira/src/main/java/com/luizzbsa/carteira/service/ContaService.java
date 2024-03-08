package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.dto.DadosContaDTO;
import com.luizzbsa.carteira.model.dto.DadosTransacaoDTO;
import com.luizzbsa.carteira.model.entity.Conta;
import com.luizzbsa.carteira.model.entity.Usuario;
import com.luizzbsa.carteira.model.repository.ContaDAO;
import com.luizzbsa.carteira.model.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaDAO repositoryConta;
    @Autowired
    UsuarioDAO repositoryUsuario;
    public List<DadosContaDTO> listarTodos() {
        List<DadosContaDTO> lista = new ArrayList();
        repositoryConta.findAll().forEach(conta -> {
            lista.add(new DadosContaDTO(conta));
        });

        return lista;

    }

    public DadosContaDTO listarPorId(Long id) {
        Conta conta = repositoryConta.getReferenceById(id);
        return new DadosContaDTO(conta);
    }

    public DadosContaDTO salvarConta(DadosContaDTO dados) {
        Usuario usuario = repositoryUsuario.getReferenceById(dados.usuario_id());
        Conta conta = new Conta(dados, usuario);
        repositoryConta.save(conta);
        return new DadosContaDTO(conta);
    }

    public DadosContaDTO deletarConta(Long id) {
        Conta conta = repositoryConta.getReferenceById(id);
        repositoryConta.delete(conta);
        return new DadosContaDTO(conta);
    }

    public DadosContaDTO alterarConta(Long id, DadosContaDTO dadosNovos) {
        Conta contaAntiga = repositoryConta.getReferenceById(id);
        substituirDadosConta(contaAntiga, dadosNovos);
        return new DadosContaDTO(contaAntiga);
    }

    private void substituirDadosConta(Conta contaAntiga, DadosContaDTO dadosNovos) {
        if(dadosNovos.saldo() != null){
            contaAntiga.setSaldo(dadosNovos.saldo());
        }
        if(dadosNovos.credito() != null){
            contaAntiga.setCredito(dadosNovos.credito());
            }
        if(dadosNovos.debito() != null){
            contaAntiga.setDebito(dadosNovos.debito());
        }


    }
}
