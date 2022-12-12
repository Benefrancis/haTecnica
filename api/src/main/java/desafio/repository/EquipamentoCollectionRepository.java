package desafio.repository;

import desafio.model.cliente.Cliente;
import desafio.model.equipamento.Computador;
import desafio.model.equipamento.Equipamento;
import desafio.model.equipamento.Mobile;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

public final class EquipamentoCollectionRepository {

    private static List<Equipamento> equipamentos;


    private EquipamentoCollectionRepository() {
    }

    static {

        equipamentos = new Vector<>();

        Cliente c1 = ClienteCollectionRepository.findById(1L).orElse(null);
        Cliente c2 = ClienteCollectionRepository.findById(2L).orElse(null);

        Equipamento e1 = new Computador(1L, c1, "DELL132465");
        Equipamento e2 = new Mobile(2L, c2, "IPHONE12346");

        equipamentos.add(e1);
        equipamentos.add(e2);
    }


    public static List<Equipamento> findAll() {
        return equipamentos;
    }

    public static Optional<Equipamento> findById(Long id) {
        return equipamentos.stream().filter(c -> c.getId() == id).findFirst();
    }

    public static List<Equipamento> findByTipo(Equipamento.TipoEquipamento tipo) {
        return equipamentos.stream().filter(c -> c.getTipo().equals(tipo)).toList();
    }

    public static List<Equipamento> findByNumeroDeSerie(String numeroDeSerie) {
        return equipamentos.stream().filter(c -> c.getNumeroDeSerie().equalsIgnoreCase(numeroDeSerie)).toList();
    }

    public static List<Equipamento> findByCliente(Cliente cliente) {
        return equipamentos.stream().filter(c -> c.getCliente().equals(cliente)).toList();
    }

}
