package br.com.fiap.shift.desafio.model;

public abstract class Cliente implements Autenticavel {

    private Long id;

    private TipoCliente tipo;

    private String nome;


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


    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

     enum  TipoCliente {
        PF(1, "Pessoa Física"), PJ(2, "Pessoa Jurídica");

        private final int valor;
        private final String nome;

        TipoCliente(int i, String nome) {
            valor = i;
            this.nome = nome;
        }

        public int getValor() {
            return valor;
        }

        public String getNome() {
            return nome;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TipoCliente{");
            sb.append("valor=").append(valor);
            sb.append(", nome='").append(nome).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
