package com.luizzbsa.carteira.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int id;
    private Usuario usuario;
    private float saldo;
    private float debito;
    private float credito;
    private List<Transações> lista = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getDebito() {
        return debito;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }
}
