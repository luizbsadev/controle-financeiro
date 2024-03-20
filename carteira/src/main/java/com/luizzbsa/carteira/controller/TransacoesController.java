package com.luizzbsa.carteira.controller;

import com.luizzbsa.carteira.model.dto.*;
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
    private TransacaoService service;
    @Autowired
    public TransacoesController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping()
    ResponseEntity<List<DadosListarTransacaoDTO>> listarTodos(@RequestHeader(HttpHeaders.AUTHORIZATION) String token ){
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
    public ResponseEntity<DadosTransacaoDTO> criar(@RequestBody DadosCriarTransacaoDTO dados,
                                                    @RequestHeader(HttpHeaders.AUTHORIZATION) String token)
                                                    throws URISyntaxException {

        DadosTransacaoDTO dadosTransacaoDTO = service.salvarTransacao(dados, token);
        URI location = new URI("/transacoes/"+dadosTransacaoDTO.id());
        return ResponseEntity.created(location).body(dadosTransacaoDTO);
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity<DadosDeletarTransacaoDTO> deletar(@RequestParam("id") Long id,
                                                     @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            DadosDeletarTransacaoDTO dados = service.deletarTransacao(id, token);
            return ResponseEntity.ok(dados);

        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    @Transactional
    public ResponseEntity alterar(@RequestParam("id") Long id,
                                  @RequestBody DadosAlterarTransacaoDTO dadosNovos,
                                  @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            DadosAlterarTransacaoDTO dados = service.alterarTransacao(id, dadosNovos, token);
            return ResponseEntity.ok(dados);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

}
