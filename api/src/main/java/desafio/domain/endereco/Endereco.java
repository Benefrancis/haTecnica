package desafio.domain.endereco;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HT_ENDERECO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"ID_ENDERECO"},
                name = "PK_ENDERECO"),
        indexes = {
                @Index(
                        columnList = "CEP",
                        name = "IDX_CEP_ENDERECO"
                )
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_ENDERECO")
    @SequenceGenerator(name = "SEQ_HT_ENDERECO", sequenceName = "SEQ_HT_ENDERECO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;


    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE", foreignKey = @ForeignKey(name = "FK_CIDADE_ENDERECO", value = ConstraintMode.CONSTRAINT))
    private Cidade cidade;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_ENDERECO", value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;


    public Endereco(PutEndereco dados) {
        this.id = dados.id();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = new Cidade(dados.cidade());
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.logradouro = dados.logradouro();
        this.cliente = new Cliente(dados.cliente());
    }


    public Endereco setId(Long id) {
        this.id = id;
        return this;
    }


    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }


    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }


    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }


    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }


    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }


    public Endereco setCidade(Cidade cidade) {
        this.cidade = cidade;
        return this;
    }


    public Endereco setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public void atualizarInformacoes(PutEndereco dados) {

        this.id = dados.id();

        if (!dados.numero().equals(null)) {
            this.numero = dados.numero();
        }

        if (!dados.cep().equals(null)) {
            this.cep = dados.cep();
        }

        if (!dados.bairro().equals(null)) {
            this.bairro = dados.bairro();
        }

        if (!dados.complemento().equals(null)) {
            this.complemento = dados.complemento();
        }

        if (!dados.cidade().equals(null)) {
            this.cidade.atualizarInformacoes(dados.cidade());
        }


        if (!dados.logradouro().equals(null)) {
            this.logradouro = dados.logradouro();
        }


        if (!dados.cliente().equals(null)) {
            this.cliente.atualizarInformacoes(dados.cliente());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Endereco{");
        sb.append("id=").append(id);
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
        sb.append(", bairro='").append(bairro).append('\'');
        sb.append(", cep='").append(cep).append('\'');
        sb.append(", cidade=").append(cidade);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }
}


