package desafio.domain.documento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.Cliente;
import desafio.domain.documento.dto.PutDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "HT_DOCUMENTO",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = "ID_DOCUMENTO",
            name = "PK_DOCUMENTO"
        )
    },
    indexes = @Index(
            columnList = "NUMERO",
            name = "IDX_NUMERO_DOCUMENTO"
    )
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_HT_DOCUMENTO", sequenceName = "SEQ_HT_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;


    @Column(name = "NUMERO")
    private String numero;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_DOCUMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO", foreignKey = @ForeignKey(name = "FK_TIPO_DOCUMENTO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private TipoDocumento tipo;


    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EMISSAO")
    private LocalDate emissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_VALIDADE")
    private LocalDate validade;


    public Documento(PutDocumento dados) {
        this.id = dados.id();
        this.numero = dados.numero();
        this.tipo = new TipoDocumento(dados.tipo());
        this.emissao = dados.emissao();
        this.validade = dados.validade();
        if (dados.cliente() != null) this.cliente = new Cliente(dados.cliente());
    }


    public Documento setId(Long id) {
        this.id = id;
        return this;
    }



    public Documento setNumero(String numero) {
        this.numero = numero;
        return this;
    }



    public Documento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }



    public Documento setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
        return this;
    }



    public Documento setEmissao(LocalDate emissao) {
        this.emissao = emissao;
        return this;
    }



    public Documento setValidade(LocalDate validade) {
        this.validade = validade;
        return this;
    }

     public void atualizarInforamcoes(PutDocumento dados) {
        this.id = dados.id();
        this.numero = dados.numero();
        this.tipo = new TipoDocumento(dados.tipo());
        this.emissao = dados.emissao();
        this.validade = dados.validade();
    }

    @Override
    public String toString() {
        String sb = "Documento{" + "id=" + id +
                ", numero='" + numero + '\'' +
                ", cliente=" + cliente +
                ", tipo=" + tipo +
                ", emissao=" + emissao +
                ", validade=" + validade +
                '}';
        return sb;
    }
}
