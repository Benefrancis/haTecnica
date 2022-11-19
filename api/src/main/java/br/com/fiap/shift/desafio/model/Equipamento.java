package br.com.fiap.shift.desafio.model;

public class Equipamento {

    private Long id;

    private Cliente cliente;

    private String numeroDeSerie;

    private TipoEquipamento tipo;


    public Equipamento(Cliente cliente, TipoEquipamento tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
    }


    public Equipamento(Long id, Cliente cliente, String numeroDeSerie, TipoEquipamento tipo) {
        this.id = id;
        this.cliente = cliente;
        this.numeroDeSerie = numeroDeSerie;
        this.tipo = tipo;
    }

    enum TipoEquipamento {
        COMPUTADOR(1, "Computador"), MOBILE(2, "Mobile"), VIDEO_GAME(3, "Vídeo game");

        private final int valor;
        private final String nome;

        TipoEquipamento(int i, String nome) {
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
            final StringBuffer sb = new StringBuffer("TipoEquipamento{");
            sb.append("valor=").append(valor);
            sb.append(", nome='").append(nome).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    public Long getId() {
        return id;
    }

    public Equipamento setId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public Equipamento setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
        return this;
    }

    public TipoEquipamento getTipo() {
        return tipo;
    }

    public Equipamento setTipo(TipoEquipamento tipo) {
        this.tipo = tipo;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Equipamento{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", numeroDeSerie='").append(numeroDeSerie).append('\'');
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
