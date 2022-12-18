package desafio.domain.cliente.service;

import desafio.domain.cliente.PessoaFisica;
import desafio.domain.cliente.repository.PessoaFisicaRepository;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.endereco.repository.CidadeRepository;
import desafio.domain.endereco.repository.EnderecoRepository;
import desafio.domain.endereco.repository.EstadoRepository;
import desafio.domain.endereco.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;

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

    public PessoaFisica findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Collection<PessoaFisica> findAll() {
        return repository.findAll();
    }

    public PessoaFisica save(PessoaFisica pf) {

        if (!pf.getEndereco().equals(null)) {
            enderecoRepository.save(pf.getEndereco());
            if (!pf.getEndereco().getCidade().equals(null)) {
                cidadeRepository.save(pf.getEndereco().getCidade());
                if (!pf.getEndereco().getCidade().getEstado().equals(null)) {
                    estadoRepository.save(pf.getEndereco().getCidade().getEstado());
                    if (!pf.getEndereco().getCidade().getEstado().getPais().equals(null)) {
                        paisRepository.save(pf.getEndereco().getCidade().getEstado().getPais());
                    }
                }
            }
        }

        repository.save(pf);
        return pf;
    }

}
