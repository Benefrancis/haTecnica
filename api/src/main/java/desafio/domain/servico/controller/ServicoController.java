package desafio.domain.servico.controller;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.dto.ListCliente;
import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.servico.Servico;
import desafio.domain.servico.dto.ListServico;
import desafio.domain.servico.dto.PutServico;
import desafio.domain.servico.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;


    @GetMapping
    public Page<ListServico> findAll(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ListServico::new);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PutServico> findById(@PathVariable("id") Long id) {
        var resposta = repository.findById(id).orElse(null);
        return resposta != null ? ResponseEntity.ok(new PutServico(resposta)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PutServico> save(@RequestBody @Valid PutServico dados, UriComponentsBuilder builder) {
        var servico = repository.save(new Servico(dados));
        URI uri = builder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();
        return ResponseEntity.created(uri).body(new PutServico(servico));
    }


    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PutServico dados) {
        var servico = repository.getReferenceById(dados.id());
        servico.atualizarInformacoes(dados);
    }
}
