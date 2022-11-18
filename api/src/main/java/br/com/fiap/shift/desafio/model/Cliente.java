package br.com.fiap.shift.desafio.model;

public abstract class Cliente implements Autenticavel {

    private Long id;

    private TipoCliente tipo;

    private String nome;

    enum TipoCliente {
        PF, PJ
    }

    public Cliente(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public Cliente setTipo(TipoCliente tipo) {
        this.tipo = tipo;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
