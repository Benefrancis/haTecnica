package desafio.model.cliente;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_DOCUMENTO", sequenceName = "SEQ_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_DOCUMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;

    private String numero;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EMISSAO")
    private LocalDate emissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_VALIDADE")
    private LocalDate validade;

    @Enumerated(EnumType.ORDINAL)
    private TipoDocumento tipo;


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

    public Documento() {

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
        String sb = "Documento{" + "id=" + id +
                ", cliente=" + cliente +
                ", numero='" + numero + '\'' +
                ", emissao=" + emissao +
                ", validade=" + validade +
                ", tipo=" + tipo +
                '}';
        return sb;
    }


    enum TipoDocumento {

        RG(1, "RG"), CPF(2, "CPF"), CNPJ(3, "CNPJ");

        private final int valor;
        private final String nome;

        TipoDocumento(int i, String nome) {
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
            String sb = " {" + "valor: " + valor +
                    ", nome : '" + nome + '\'' +
                    '}';
            return sb;
        }
    }
}
