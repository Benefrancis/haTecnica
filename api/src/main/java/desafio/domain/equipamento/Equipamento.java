package desafio.domain.equipamento;

import desafio.domain.cliente.Cliente;
import desafio.domain.equipamento.dto.PutEquipamento;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "HT_EQUIPAMENTO",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"ID_EQUIPAMENTO"},
                        name = "PK_EQUIPAMENTO"
                )
        },
        indexes = {
                @Index(
                        name = "idx_equipamento_nr_serie",
                        columnList = "NR_SERIE"
                )
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_EQUIPAMENTO")
    @SequenceGenerator(name = "SEQ_HT_EQUIPAMENTO", sequenceName = "SEQ_HT_EQUIPAMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_EQUIPAMENTO")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_EQUIPAMENTO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;

    @Column(name = "NR_SERIE")
    private String numeroDeSerie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO", referencedColumnName = "ID_TIPO_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_TIPO_EQUIPAMENTO", value = ConstraintMode.CONSTRAINT))
    private TipoEquipamento tipo;


    public Equipamento(PutEquipamento e) {
        this.id = e.id();
        this.cliente = new Cliente(e.cliente());
        this.numeroDeSerie = e.numeroDeSerie();
        this.tipo = new TipoEquipamento(e.tipo());
    }


    public Equipamento setId(Long id) {
        this.id = id;
        return this;
    }


    public Equipamento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }


    public Equipamento setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
        return this;
    }


    public Equipamento setTipo(TipoEquipamento tipo) {
        this.tipo = tipo;
        return this;
    }


    public void atualizarInforamcoes(PutEquipamento e) {

        if (e.tipo() != null) {
            this.setTipo(new TipoEquipamento(e.tipo()));
        }

        if (e.numeroDeSerie() != null) {
            this.numeroDeSerie = e.numeroDeSerie();
        }

        if (e.cliente() != null) {
            if (this.getCliente() != null) {
                this.getCliente().atualizarInformacoes(e.cliente());
            } else {
                this.setCliente(new Cliente(e.cliente()));
            }
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipamento{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", numeroDeSerie='").append(numeroDeSerie).append('\'');
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
