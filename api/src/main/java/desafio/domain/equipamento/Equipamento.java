package desafio.domain.equipamento;

import desafio.domain.cliente.Cliente;
import desafio.domain.documento.TipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.context.annotation.Primary;


@Entity
@Table(name = "HT_EQUIPAMENTO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ID_TIPO_EQUIPAMENTO", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Equipamento {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_EQUIPAMENTO"  )
    @SequenceGenerator(name = "SEQ_HT_EQUIPAMENTO", sequenceName = "SEQ_HT_EQUIPAMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_EQUIPAMENTO")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_EQUIPAMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;


    @Column(name = "NR_SERIE")
    private String numeroDeSerie;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO", referencedColumnName = "ID_TIPO_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_TIPO_EQUIPAMENTO", value = ConstraintMode.CONSTRAINT), insertable=false, updatable=false)
    private TipoEquipamento tipo;

    public Equipamento(Long id, Cliente cliente, String numeroDeSerie) {
        this.id = id;
        this.cliente = cliente;
        this.numeroDeSerie = numeroDeSerie;

    }

    public Equipamento() {

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipamento{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", numeroDeSerie='").append(numeroDeSerie).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
