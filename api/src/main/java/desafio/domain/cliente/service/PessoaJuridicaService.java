package desafio.domain.cliente.service;

import desafio.domain.cliente.PessoaJuridica;
import desafio.domain.cliente.repository.PessoaJuridicaRepository;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.endereco.repository.CidadeRepository;
import desafio.domain.endereco.repository.EnderecoRepository;
import desafio.domain.endereco.repository.EstadoRepository;
import desafio.domain.endereco.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

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

    public PessoaJuridica findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Collection<PessoaJuridica> findAll() {
        return repository.findAll();
    }

    public PessoaJuridica save(PessoaJuridica pj) {
        if (pj.getTipo() != null) {
            tipoClienteRepository.save(pj.getTipo());

            if (pj.getEndereco() != null) {
                enderecoRepository.save(pj.getEndereco());
                if (pj.getEndereco().getCidade() != null) {
                    cidadeRepository.save(pj.getEndereco().getCidade());
                    if (pj.getEndereco().getCidade().getEstado() != null) {
                        estadoRepository.save(pj.getEndereco().getCidade().getEstado());
                        if (pj.getEndereco().getCidade().getEstado().getPais() != null) {
                            paisRepository.save(pj.getEndereco().getCidade().getEstado().getPais());
                        }
                    }
                }
            }
        }

        repository.save(pj);
        return pj;


    }
}
