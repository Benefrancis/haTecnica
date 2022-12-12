package desafio.repository;

import desafio.model.cliente.Cliente;
import desafio.model.cliente.PessoaFisica;
import desafio.model.cliente.PessoaJuridica;
import desafio.model.cliente.Telefone;


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


        Telefone tel = new Telefone();

        tel.setDdi("55").setDdd("11").setNumero("982816536").setId(1L);

        c1.setTelefone(tel);


        Cliente c2 = new PessoaJuridica(2L, "FIAP", "Faculdade de Informática e Administração Paulista");

        Telefone tel2 = new Telefone();

        tel2.setDdi("55").setDdd("11").setNumero("58917418").setId(2L);
        c2.setTelefone(tel2);

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
