package com.luizzbsa.carteira.controller;

import com.luizzbsa.carteira.model.dto.DadosContaDTO;
import com.luizzbsa.carteira.service.ContaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService service;
    @Autowired
    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping()
    ResponseEntity<List<DadosContaDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping()
    @RequestMapping(value = "/{id}")
    ResponseEntity<DadosContaDTO> listarPorId(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(service.listarPorId(id));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<DadosContaDTO> salvar(@RequestBody DadosContaDTO dados) throws URISyntaxException {
        DadosContaDTO novosDadosCriado = service.salvarConta(dados);
        URI location = new URI("/conta/"+novosDadosCriado.id());
        return ResponseEntity.created(location).body(novosDadosCriado);
    }


    @DeleteMapping()
    @Transactional
    public ResponseEntity<DadosContaDTO> deletar(@RequestParam("id") Long id){
        try {
            DadosContaDTO dados = service.deletarConta(id);
            return ResponseEntity.ok(dados);

        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }



    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DadosContaDTO> alterar(@RequestParam("id") Long id, @RequestBody DadosContaDTO dadosNovos){
        try {
            DadosContaDTO dados = service.alterarConta(id, dadosNovos);
            return ResponseEntity.ok(dados);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

}
