package desafio.model.cliente;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
    @SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;


    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CEP", referencedColumnName = "ID_CEP",foreignKey = @ForeignKey(name = "FK_CEP_ENDERECO", value = ConstraintMode.CONSTRAINT) )
    private CEP cep;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE", foreignKey = @ForeignKey(name = "FK_CIDADE_ENDERECO", value = ConstraintMode.CONSTRAINT) )
    private Cidade cidade;


    public Endereco() {
    }

    public Endereco(CEP cep) {
        this.cep = cep;
    }


    public Endereco(String logradouro, String numero, String complemento, String bairro, CEP cep, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }


    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public CEP getCep() {
        return cep;
    }

    public Endereco setCep(CEP cep) {
        this.cep = cep;
        return this;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Endereco setCidade(Cidade cidade) {
        this.cidade = cidade;
        return this;
    }
}


@Entity
class CEP implements Validavel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CEP")
    @SequenceGenerator(name = "SEQ_CEP", sequenceName = "SEQ_CEP", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CEP")
    private Long id;


    private String cep;

    public CEP(String cep) {

        if (validar(cep)) {
            this.cep = cep;
        } else {
            throw new RuntimeException("O CEP " + cep + " é inválido!");
        }
    }

    public CEP() {

    }


    public Long getId() {
        return id;
    }

    public CEP setId(Long id) {
        if (validar(cep)) {
            this.cep = cep;
        } else {
            throw new RuntimeException("O CEP " + cep + " é inválido!");
        }
        return this;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public boolean validar(String t) {
        return t.matches("[0-9]{5}-[0-9]{3}");
    }

    @Override
    public String toString() {
        return cep;
    }

}


