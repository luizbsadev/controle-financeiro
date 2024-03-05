package com.luizzbsa.carteira.controller;

import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.repository.TransacoesDAO;
import com.luizzbsa.carteira.service.TransacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesDAO repository;
    @Autowired
    private TransacaoService service;


    @GetMapping()
    List<Transacao> all(){
        return repository.findAll();
    }

    @PostMapping()
    @Transactional
    public void salvar(@RequestBody Transacao transacao){
        repository.save(transacao);
    }

    @DeleteMapping()
    @Transactional
    public void deletar(@RequestParam("id") long id){
        repository.deleteById(id);
    }

    @PutMapping()
    @Transactional
    public void alterar(@RequestParam("id") Long id, @RequestBody Transacao transacaoNova){
        Transacao transacao = repository.getReferenceById(id);
        service.alterarInformacoesTransacao(transacao, transacaoNova);



    }
}
