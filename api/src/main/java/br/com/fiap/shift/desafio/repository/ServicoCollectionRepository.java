package br.com.fiap.shift.desafio.repository;

import br.com.fiap.shift.desafio.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public final class ServicoCollectionRepository {

    private static List<Servico> servicos;

    private ServicoCollectionRepository() {
    }

    static {

        servicos = new Vector<>();

        Equipamento e1 = EquipamentoCollectionRepository.findById(1L).orElse(null);
        Equipamento e2 = EquipamentoCollectionRepository.findById(2L).orElse(null);

        Servico s1 = new Limpeza(1L, e1, 159.90, "Realizamos alimpeza das peças", LocalDateTime.now().minusHours(5), LocalDateTime.now().minusHours(4), LocalDateTime.now());
        Servico s2 = new SubstitucaoDePeca(1L, e1, 159.90, "Realizamos a troca da tela do celular", LocalDateTime.now().minusHours(5), LocalDateTime.now().minusHours(4), LocalDateTime.now(), "Tela do Mobile");

        servicos.add(s1);
        servicos.add(s2);
    }


    public static List<Servico> findAll() {
        return servicos;
    }

    public static Optional<Servico> findById(Long id) {
        return servicos.stream().filter(c -> c.getId() == id).findFirst();
    }

    public static List<Servico> findByTipo(Servico.TipoServico tipo) {
        return servicos.stream().filter(c -> c.getTipo().equals(tipo)).toList();
    }

    public static List<Servico> findByEquipamento(Equipamento equipamento) {
        return servicos.stream().filter(c -> c.getEquipamento().equals(equipamento)).toList();
    }

    public static List<Servico> findByCliente(Cliente cliente) {
        return servicos.stream().filter(c -> c.getEquipamento().getCliente().equals(cliente)).toList();
    }

}
