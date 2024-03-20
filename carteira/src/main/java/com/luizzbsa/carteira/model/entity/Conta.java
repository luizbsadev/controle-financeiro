package com.luizzbsa.carteira.model.entity;

import com.luizzbsa.carteira.model.dto.DadosContaDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CONTA")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;
    private BigDecimal saldo;
    private BigDecimal debito;
    private BigDecimal credito;

    @OneToMany(mappedBy = "conta")
    private List<Transacao> transacoes;

    public Conta(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = new BigDecimal(0);
        this.debito = new BigDecimal(0);
        this.credito = new BigDecimal(0);
    }

    public Conta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public void somarValor(BigDecimal valor) {
        this.saldo = saldo.add(valor);
        this.credito = credito.add(valor);
    }

    public void subtrairValor(BigDecimal valor){
        this.saldo = saldo.subtract(valor);
        this.debito = debito.add(valor);
    }
}


