package br.com.fiap.shift.desafio.model;

public class Mobile extends Equipamento {
    public Mobile(Cliente cliente) {
        super(cliente, TipoEquipamento.MOBILE);
    }

    public Mobile(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.MOBILE);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mobile{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
