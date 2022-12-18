package desafio.controller;

import desafio.domain.cliente.PessoaJuridica;
import desafio.domain.cliente.dto.ListPessoaJuridica;
import desafio.domain.cliente.dto.PutPessoaJuridica;
import desafio.domain.cliente.repository.PessoaJuridicaRepository;
import desafio.domain.cliente.service.PessoaJuridicaService;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pj")
public class PessoaJuridicaController {

    Logger log = LoggerFactory.getLogger(PessoaJuridicaController.class);

    @Autowired
    PessoaJuridicaService service;

    @Autowired
    PessoaJuridicaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<PutPessoaJuridica> save(@RequestBody @Valid PutPessoaJuridica dados, UriComponentsBuilder builder) {
        var pj = service.save(new PessoaJuridica(dados));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(pj.getId()).toUri();
        return ResponseEntity.created(uri).body(new PutPessoaJuridica(pj));
    }

    @PutMapping
    @Transactional
    public void atualizarPessoaJuridica(@RequestBody @Valid PutPessoaJuridica dados) {
        var pj = repository.getReferenceById(dados.id());
        pj.atualizarInformacoes(dados);
    }


    @GetMapping
    public Page<ListPessoaJuridica> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ListPessoaJuridica::new);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PutPessoaJuridica> findById(@PathVariable Long id) {
        log.info("Recebido o pedido de informações do cliente com id  {}", id);
        var pj = service.findById(id);
        if (pj != null) {
            return ResponseEntity.ok(new PutPessoaJuridica(pj));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
