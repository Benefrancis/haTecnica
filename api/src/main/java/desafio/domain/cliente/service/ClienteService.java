package desafio.domain.cliente.service;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.endereco.repository.CidadeRepository;
import desafio.domain.endereco.repository.EnderecoRepository;
import desafio.domain.endereco.repository.EstadoRepository;
import desafio.domain.endereco.repository.PaisRepository;
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

    public Cliente save(Cliente c) {

        if (c.getId() != null) {
            var cRepo = repository.getReferenceById(c.getId());
            cRepo.atualizarInformacoes(new PutCliente(c));
        }

        if (c.getTipo() != null) {
            if (c.getTipo().getId() != null) {
                var tRepo = tipoClienteRepository.getReferenceById(c.getTipo().getId());
                c.setTipo(tRepo);
            }
        }

        if (c.getEndereco() != null) {

            if (c.getEndereco().getCidade() != null) {


                if (c.getEndereco().getCidade().getEstado() != null) {

                    if (c.getEndereco().getCidade().getEstado().getPais() != null) {
                        if (c.getEndereco().getCidade().getEstado().getPais().getId() != null) {
                            var paisRepo = paisRepository.getReferenceById(c.getEndereco().getCidade().getEstado().getPais().getId());
                            c.getEndereco().getCidade().getEstado().setPais(paisRepo);
                        }
                    }


                    if (c.getEndereco().getCidade().getEstado().getId() != null) {
                        var estadoRepo = estadoRepository.getReferenceById(c.getEndereco().getCidade().getEstado().getId());
                        c.getEndereco().getCidade().setEstado(estadoRepo);
                    }
                }


                if (c.getEndereco().getCidade().getId() != null) {
                    var cidadeRepo = cidadeRepository.getReferenceById(c.getEndereco().getCidade().getId());
                    c.getEndereco().setCidade(cidadeRepo);
                }
            }


            if (c.getEndereco().getId() != null) {
                var endRepo = enderecoRepository.getReferenceById(c.getEndereco().getId());
                c.setEndereco(endRepo);
            }


        }

        repository.save(c);
        return repository.getReferenceById(c.getId());
    }

}
