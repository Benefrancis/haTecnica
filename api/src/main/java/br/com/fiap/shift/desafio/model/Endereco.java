package br.com.fiap.shift.desafio.model;

import java.io.Serializable;

public class Endereco implements Serializable {

    private Long id;

    private Cliente cliente;

    private String CEP;

    private String logradouro;

    private String numero;

    public Endereco(Long id, Cliente cliente, String CEP, String logradouro, String numero) {
        this.id = id;
        this.cliente = cliente;
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public Endereco() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public String getCEP() {
        return CEP;
    }

    public Endereco setCEP(String CEP) {
        this.CEP = CEP;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Endereco{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", CEP='").append(CEP).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

