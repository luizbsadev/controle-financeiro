package com.luizzbsa.carteira.model.entity;

import com.luizzbsa.carteira.model.entity.dto.DadosTransacaoSalvarDTO;
import com.luizzbsa.carteira.model.entity.enums.TipoTransacao;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TRANSACOES")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Conta conta;
    private BigDecimal valor;
    private String descricao;
    private String categoria;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    public Transacao() {
    }
    public Transacao(DadosTransacaoSalvarDTO dados, Conta conta) {
        this.conta = conta;
        this.valor = dados.valor();
        this.descricao = dados.descricao();
        this.tipoTransacao = dados.tipoTransacao();
        this.categoria = dados.categoria();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}

