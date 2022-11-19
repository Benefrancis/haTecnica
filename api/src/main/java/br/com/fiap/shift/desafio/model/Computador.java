package br.com.fiap.shift.desafio.model;

public class Computador extends Equipamento {
    public Computador(Cliente cliente) {
        super(cliente, TipoEquipamento.COMPUTADOR);
    }

    public Computador(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.COMPUTADOR);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Computador{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
