package br.com.fiap.shift.desafio.model;

import java.time.LocalDate;

public class Documento {

    private Long id;

    private Cliente cliente;

    private String numero;


    private LocalDate emissao;

    private LocalDate validade;

    private TipoDocumento tipo;


    enum TipoDocumento {
        RG, CPF, CNPJ
    }

    public Documento(Long id, Cliente cliente, String numero, LocalDate emissao, LocalDate validade, TipoDocumento tipo) {
        this.id = id;
        this.cliente = cliente;
        this.numero = numero;
        this.emissao = emissao;
        this.validade = validade;
        this.tipo = tipo;
    }

    public Documento(Cliente cliente) {
        this.cliente = cliente;
    }


    public Long getId() {
        return id;
    }

    public Documento setId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Documento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Documento setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public Documento setEmissao(LocalDate emissao) {
        this.emissao = emissao;
        return this;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public Documento setValidade(LocalDate validade) {
        this.validade = validade;
        return this;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public Documento setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Documento{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", emissao=").append(emissao);
        sb.append(", validade=").append(validade);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
