package com.luizzbsa.carteira.controller;

import com.luizzbsa.carteira.model.dto.DadosTransacaoDTO;
import com.luizzbsa.carteira.service.TransacaoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    private TransacaoService service;


    @GetMapping()
    ResponseEntity<List<DadosTransacaoDTO>> listarTodos(@RequestHeader(HttpHeaders.AUTHORIZATION) String token ){
        System.out.println(token);
        return ResponseEntity.ok(service.listarTodos(token));
    }

    @GetMapping()
    @RequestMapping(value = "/{id}")
    ResponseEntity<DadosTransacaoDTO> listarPorId(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(service.listarPorId(id));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<DadosTransacaoDTO> salvar(@RequestBody DadosTransacaoDTO dados) throws URISyntaxException {
        URI location = new URI("/transacoes/"+dados.id());
        return ResponseEntity.created(location).body(service.salvarTransacao(dados));
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity<DadosTransacaoDTO> deletar(@RequestParam("id") Long id){
        try {
            DadosTransacaoDTO dados = service.deletarTransacao(id);
            return ResponseEntity.ok(dados);

        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }




    }

    @PutMapping()
    @Transactional
    public ResponseEntity alterar(@RequestParam("id") Long id, @RequestBody DadosTransacaoDTO dadosNovos){
        try {
            DadosTransacaoDTO dados = service.alterarTransacao(id, dadosNovos);
            return ResponseEntity.ok(dados);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }



    }
}
