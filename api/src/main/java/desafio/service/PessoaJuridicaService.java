package desafio.service;

import desafio.model.cliente.PessoaJuridica;
import desafio.oracle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaJuridicaService {


    @Autowired
    private PessoaJuridicaRepository repository;
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

    public PessoaJuridica findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Collection<PessoaJuridica> findAll() {
        return repository.findAll();
    }

    public PessoaJuridica save(PessoaJuridica pj) {
//        paisRepository.save(pf.getEndereco().getCidade().getEstado().getPais());
//        estadoRepository.save(pf.getEndereco().getCidade().getEstado());
//        cidadeRepository.save(pf.getEndereco().getCidade());
//        cepRepository.save(pf.getEndereco().getCep());
//        enderecoRepository.save(pf.getEndereco());
//        telefoneRepository.save(pf.getTelefone());
//        tipoClienteRepository.save(pf.getTipo());
//        repository.save(pf);
//        return pf;


        if (!pj.getEndereco().equals(null)) {

            if (!pj.getEndereco().getCep().equals(null)) {
                cepRepository.save(pj.getEndereco().getCep());
            }
            enderecoRepository.save(pj.getEndereco());
            if (!pj.getEndereco().getCidade().equals(null)) {
                cidadeRepository.save(pj.getEndereco().getCidade());
                if (!pj.getEndereco().getCidade().getEstado().equals(null)) {
                    estadoRepository.save(pj.getEndereco().getCidade().getEstado());
                    if (!pj.getEndereco().getCidade().getEstado().getPais().equals(null)) {
                        paisRepository.save(pj.getEndereco().getCidade().getEstado().getPais());
                    }
                }
            }
        }


        if (!pj.getTelefone().equals(null)) {
            telefoneRepository.save(pj.getTelefone());
        }
        if (!pj.getTelefone().equals(null)) {
            tipoClienteRepository.save(pj.getTipo());
        }

        repository.save(pj);
        return pj;


    }
}
