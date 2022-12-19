package desafio.domain.cliente;

import desafio.domain.endereco.Endereco;
import desafio.domain.equipamento.TipoEquipamento;
import jakarta.persistence.*;

@Entity
@Table(name = "HT_CLIENTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ID_TIPO_CLIENTE", discriminatorType = DiscriminatorType.INTEGER)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_CLIENTE", sequenceName = "SEQ_HT_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;

    private String nome;


    @Embedded
    private Telefone telefone;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE", value = ConstraintMode.CONSTRAINT))
    private Endereco endereco;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID_TIPO_CLIENTE", foreignKey = @ForeignKey(name = "FK_TIPO_CLIENTE", value = ConstraintMode.CONSTRAINT), insertable=false, updatable=false)
    private TipoCliente tipo;


    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(Long id, String nome, Telefone telefone, Endereco endereco, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public Cliente() {
    }

    public Cliente(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public Cliente setTipo(TipoCliente tipo) {
        this.tipo = tipo;
        return this;
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
