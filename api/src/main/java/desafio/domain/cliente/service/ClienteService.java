package desafio.domain.cliente.service;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.endereco.repository.CidadeRepository;
import desafio.domain.endereco.repository.EnderecoRepository;
import desafio.domain.endereco.repository.EstadoRepository;
import desafio.domain.endereco.repository.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private TipoClienteRepository tipoClienteRepository;


    public Cliente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Collection<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(@Valid Cliente c) {
        var ret = repository.saveAndFlush(c);
        return ret; //repository.findById(c.getId()).orElse(null);
    }

}
