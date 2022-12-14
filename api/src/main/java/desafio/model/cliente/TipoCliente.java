package desafio.model.cliente;


import desafio.model.cliente.dto.PutTipoCliente;
import jakarta.persistence.*;

@Entity
public class TipoCliente {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_CLIENTE")
    @SequenceGenerator(name = "SEQ_TIPO_CLIENTE", sequenceName = "SEQ_TIPO_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_CLIENTE")
    private Long id;
    private String nome;


    private String sigla;

    public TipoCliente() {
    }

    public TipoCliente(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }


    public TipoCliente(PutTipoCliente dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.sigla = dados.sigla();
    }


    public Long getId() {
        return id;
    }

    public TipoCliente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoCliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public TipoCliente setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }




    public void atualizarInformacoes(PutTipoCliente dados) {
        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }
    }

    @Override
    public String toString() {
        return sigla.toUpperCase();
    }
}