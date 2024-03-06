package com.luizzbsa.carteira.controller;

import com.luizzbsa.carteira.model.entity.Transacao;
import com.luizzbsa.carteira.model.entity.dto.DadosTransacaoDTO;
import com.luizzbsa.carteira.service.TransacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    private TransacaoService service;


    @GetMapping()
    List<DadosTransacaoDTO> all(){

        return  service.listarTodos();
    }

    @PostMapping()
    @Transactional
    public void salvar(@RequestBody DadosTransacaoDTO dados){
        service.salvarTransacao(dados);
    }

    @DeleteMapping()
    @Transactional
    public void deletar(@RequestParam("id") long id){

        //repository.deleteById(id);
    }

    @PutMapping()
    @Transactional
    public void alterar(@RequestParam("id") Long id, @RequestBody Transacao transacaoNova){
        //Transacao transacao = repository.getReferenceById(id);
        //service.alterarInformacoesTransacao(transacao, transacaoNova);



    }
}
