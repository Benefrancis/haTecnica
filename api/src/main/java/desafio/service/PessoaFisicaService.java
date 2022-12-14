package desafio.service;

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

        if (!pf.getEndereco().equals(null)) {

            if (!pf.getEndereco().getCep().equals(null)) {

                cepRepository.save(pf.getEndereco().getCep());
            }
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


        if (!pf.getTelefone().equals(null)) {
            telefoneRepository.save(pf.getTelefone());
        }
        if (!pf.getTelefone().equals(null)) {
            tipoClienteRepository.save(pf.getTipo());
        }

        repository.save(pf);
        return pf;
    }

}
