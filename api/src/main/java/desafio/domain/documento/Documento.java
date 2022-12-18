package desafio.domain.documento;

import desafio.domain.cliente.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "HT_DOCUMENTO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
public abstract class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_HT_DOCUMENTO", sequenceName = "SEQ_HT_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    private String numero;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_DOCUMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EMISSAO")
    private LocalDate emissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_VALIDADE")
    private LocalDate validade;

    public Documento() {

    }

    public Documento(Long id, String numero, Cliente cliente, LocalDate emissao, LocalDate validade) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
        this.emissao = emissao;
        this.validade = validade;
    }
}
