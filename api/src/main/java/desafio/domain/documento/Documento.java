package desafio.domain.documento;

import desafio.domain.cliente.Cliente;
import desafio.domain.documento.dto.PutDocumento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "HT_DOCUMENTO")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_HT_DOCUMENTO", sequenceName = "SEQ_HT_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    private String numero;


    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_DOCUMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO", foreignKey = @ForeignKey(name = "FK_TIPO_DOCUMENTO_CLIENTE", value = ConstraintMode.CONSTRAINT), insertable = false, updatable = false)
    private TipoDocumento tipo;


    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EMISSAO")
    private LocalDate emissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_VALIDADE")
    private LocalDate validade;

    public Documento() {

    }

    public Documento(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public Documento(Long id, String numero, Cliente cliente, TipoDocumento tipo, LocalDate emissao, LocalDate validade) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
        this.tipo = tipo;
        this.emissao = emissao;
        this.validade = validade;

    }

    public Documento(PutDocumento dados) {
        this.id = dados.id();
        this.numero = dados.numero();
        this.tipo = new TipoDocumento(dados.tipo());
        this.emissao = dados.emissao();
        this.validade = dados.validade();
    }

    public Long getId() {
        return id;
    }

    public Documento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Documento setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Documento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public Documento setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Documento{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", cliente=").append(cliente);
        sb.append(", tipo=").append(tipo);
        sb.append(", emissao=").append(emissao);
        sb.append(", validade=").append(validade);
        sb.append('}');
        return sb.toString();
    }
}
