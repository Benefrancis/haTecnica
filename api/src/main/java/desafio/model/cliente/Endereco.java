package desafio.model.cliente;

public class Endereco {

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CEP cep;

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

class CEP implements Validavel<String> {

    private final String codigoDeEnderecamentoPostal;

    public CEP(String cep) {

        if (validar(cep)) {
            this.codigoDeEnderecamentoPostal = cep;
        } else {
            throw new RuntimeException("O CEP " + cep + " é inválido!");
        }
    }

    @Override
    public boolean validar(String t) {
        return t.matches("[0-9]{5}-[0-9]{3}");
    }

    @Override
    public String toString() {
        return codigoDeEnderecamentoPostal;
    }
}


