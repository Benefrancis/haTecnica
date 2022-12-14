package desafio.model.cliente;

import desafio.model.cliente.dto.PostCliente;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Cliente implements Autenticavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID_TIPO_CLIENTE", foreignKey = @ForeignKey(name = "FK_TP_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private TipoCliente tipo;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TELEFONE", referencedColumnName = "ID_TELEFONE", foreignKey = @ForeignKey(name = "FK_TELEFONE_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private Telefone telefone;

    public Cliente(TipoCliente tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public Cliente(Long id, TipoCliente tipo, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
    }

    public Cliente(Long id, TipoCliente tipo, String nome, Endereco endereco, Telefone telefone) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Cliente() {
    }

    protected Cliente(PostCliente dados) {
        this.nome = dados.nome();
        this.tipo = new TipoCliente(dados.tipo());
        this.telefone = new Telefone(dados.telefone());
        this.endereco = new Endereco(dados.endereco());
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public Cliente setTipo(TipoCliente tipo) {
        this.tipo = tipo;
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
        sb.append(", tipo=").append(tipo);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", endereco=").append(endereco);
        sb.append(", telefone=").append(telefone);
        sb.append('}');
        return sb.toString();
    }
}
