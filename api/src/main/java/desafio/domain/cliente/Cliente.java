package desafio.domain.cliente;

import desafio.domain.endereco.Endereco;
import jakarta.persistence.*;

@Entity
@Table(name="HT_CLIENTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_CLIENTE", sequenceName = "SEQ_HT_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;


    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private Endereco endereco;

    @Embedded
    private Telefone telefone;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(Long id, String nome, Endereco endereco, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public Cliente() {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", endereco=").append(endereco);
        sb.append(", telefone=").append(telefone);
        sb.append('}');
        return sb.toString();
    }
}
