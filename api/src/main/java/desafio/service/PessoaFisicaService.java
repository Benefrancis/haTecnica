package desafio.service;

import desafio.model.cliente.Cliente;
import desafio.model.cliente.PessoaFisica;
import desafio.oracle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    public PessoaFisica findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Collection<PessoaFisica> findAll() {
        return repository.findAll();
    }

    public PessoaFisica save(PessoaFisica pf) {
        paisRepository.save(pf.getEndereco().getCidade().getEstado().getPais());
        estadoRepository.save(pf.getEndereco().getCidade().getEstado());
        cidadeRepository.save(pf.getEndereco().getCidade());
        cepRepository.save(pf.getEndereco().getCep());
        enderecoRepository.save(pf.getEndereco());
        telefoneRepository.save(pf.getTelefone());
        tipoClienteRepository.save(pf.getTipo());
        repository.save(pf);
        return pf;
    }

}
