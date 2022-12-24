package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.endereco.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "HT_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_CLIENTE", sequenceName = "SEQ_HT_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;

    private String nome;

    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;

    @Embedded
    private Telefone telefone;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private Endereco endereco;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID_TIPO_CLIENTE", foreignKey = @ForeignKey(name = "FK_TIPO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private TipoCliente tipo;


    public Cliente(PutCliente c) {
        this.id = c.id();
        this.nome = c.nome();
        this.nascimento = c.nascimento();
        if (c.telefone() != null) this.telefone = new Telefone(c.telefone());
        if (c.endereco() != null) this.endereco = new Endereco(c.endereco());
        if (c.tipo() != null) this.tipo = new TipoCliente(c.tipo());
    }


    public Cliente() {
    }

    public Cliente(Long id, String nome, LocalDate nascimento, Telefone telefone, Endereco endereco, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

        if (dados.nascimento() != null) {
            setNascimento(dados.nascimento());
        }
        if (dados.telefone() != null) {
            getTelefone().atualizarInformacoes(dados.telefone());
        }
        if (dados.endereco() != null) {
            getEndereco().atualizarInformacoes(dados.endereco());
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", nascimento=").append(nascimento);
        sb.append(", telefone=").append(telefone);
        sb.append(", endereco=").append(endereco);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

}
