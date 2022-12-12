package desafio.model.equipamento;

import desafio.model.cliente.Cliente;

public class Computador extends Equipamento {
    public Computador(Cliente cliente) {
        super(cliente, TipoEquipamento.COMPUTADOR);
    }

    public Computador(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.COMPUTADOR);
    }


    @Override
    public String toString() {
        String sb = "Computador{" + super.toString() +
                '}';
        return sb;
    }
}
