package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.endereco.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "HT_CLIENTE",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"},
                name = "UK_EMAIL_CLIENTE"),
        indexes = @Index(
                columnList = "nome",
                name = "IDX_NOME_CLIENTE"
        ))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_CLIENTE", sequenceName = "SEQ_HT_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email")
    private String email;

    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;

    @Embedded
    private Telefone telefone;


//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE", value = ConstraintMode.CONSTRAINT))
//    private Endereco endereco;


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


    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, LocalDate nascimento, Telefone telefone,  TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.tipo = tipo;
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


    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Cliente setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }



    public TipoCliente getTipo() {
        return tipo;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", nascimento=").append(nascimento);
        sb.append(", telefone=").append(telefone);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
