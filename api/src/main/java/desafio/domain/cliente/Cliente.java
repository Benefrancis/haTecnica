package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutCliente;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "HT_CLIENTE",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "ID_CLIENTE",
                        name = "PK_CLIENTE"),
                @UniqueConstraint(
                        columnNames = "EMAIL",
                        name = "UK_EMAIL_CLIENTE"
                )
        },
        indexes = {
                @Index(
                        columnList = "NOME",
                        name = "IDX_NOME_CLIENTE"
                ),
                @Index(
                        columnList = "EMAIL",
                        name = "IDX_EMAIL_CLIENTE"
                )
        }
)

@Builder
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_CLIENTE", sequenceName = "SEQ_HT_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email", nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;

    @Embedded
    private Telefone telefone;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID_TIPO_CLIENTE", foreignKey = @ForeignKey(name = "FK_TIPO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private TipoCliente tipo;


    public Cliente(PutCliente c) {
        this.id = c.id();
        this.nome = c.nome();
        this.email = c.email();
        this.nascimento = c.nascimento();
        if (c.telefone() != null) this.telefone = new Telefone(c.telefone());
        if (c.tipo() != null) this.tipo = new TipoCliente(c.tipo());
    }


    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }


    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }


    public Cliente setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }


    public Cliente setTelefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }


    public Cliente setTipo(TipoCliente tipo) {
        this.tipo = tipo;
        return this;
    }

    public void atualizarInformacoes(PutCliente dados) {

        if (dados.nome() != null) {
            setNome(dados.nome());
        }

        if (dados.email() != null) {
            setEmail(dados.email());
        }

        if (dados.nascimento() != null) {
            setNascimento(dados.nascimento());
        }
        if (dados.telefone() != null) {
            getTelefone().atualizarInformacoes(dados.telefone());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return id != null && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
