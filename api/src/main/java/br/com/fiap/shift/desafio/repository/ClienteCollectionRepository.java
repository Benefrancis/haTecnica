package br.com.fiap.shift.desafio.repository;

import br.com.fiap.shift.desafio.model.Cliente;
import br.com.fiap.shift.desafio.model.PessoaFisica;
import br.com.fiap.shift.desafio.model.PessoaJuridica;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public final class ClienteCollectionRepository {


    private static List<Cliente> clientes;


    private ClienteCollectionRepository() {

    }

    static {
        clientes = new Vector<>();

        Cliente c1 = new PessoaFisica(1L, "Benefrancis do Nascimento", LocalDate.of(1977, 3, 8));
        Cliente c2 = new PessoaJuridica(2L, "FIAP", "Faculdade de Informática e Administração Paulista");

        clientes.add(c1);
        clientes.add(c2);
    }

    public static List<Cliente> findAll() {
        return clientes;
    }

    public static Optional<Cliente> findById(Long id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public static List<Cliente> findByNomeContains(String nome) {
        return clientes.stream().filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
    }

    public static List<Cliente> findByTipo(Cliente.TipoCliente tipo) {
        return clientes.stream().filter(c -> c.getTipo().equals(tipo)).toList();
    }

}
