package desafio.model.cliente;

public class Telefone {

    private Long id;

    private String ddi;

    private String ddd;

    private String numero;


    public Telefone() {
    }

    public Telefone(Long id, String ddi, String ddd, String numero) {
        this.id = id;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public Telefone setId(Long id) {
        this.id = id;
        return this;
    }


    public String getDdi() {
        return ddi;
    }

    public Telefone setDdi(String ddi) {
        this.ddi = ddi;
        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Telefone setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone setNumero(String numero) {
        this.numero = numero;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Telefone{");
        sb.append("id=").append(id);
        sb.append(", ddi='").append(ddi).append('\'');
        sb.append(", ddd='").append(ddd).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
