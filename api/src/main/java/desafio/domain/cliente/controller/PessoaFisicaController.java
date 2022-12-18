package desafio.domain.cliente.controller;


import desafio.domain.cliente.PessoaFisica;
import desafio.domain.cliente.dto.ListPessoaFisica;
import desafio.domain.cliente.dto.PutPessoaFisica;
import desafio.domain.cliente.repository.PessoaFisicaRepository;
import desafio.domain.cliente.service.PessoaFisicaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/pf")

public class PessoaFisicaController {

    Logger log = LoggerFactory.getLogger(PessoaFisicaController.class);

    @Autowired
    PessoaFisicaService service;

    @Autowired
    PessoaFisicaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<PutPessoaFisica> save(@RequestBody @Valid PutPessoaFisica dados, UriComponentsBuilder builder) {
        var pf = service.save(new PessoaFisica(dados));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(pf.getId()).toUri();
        return ResponseEntity.created(uri).body(new PutPessoaFisica(pf));
    }


    @PutMapping
    @Transactional
    public void atualizarPessoaFisica(@RequestBody @Valid PutPessoaFisica dados) {
        var pf = repository.getReferenceById(dados.id());
        pf.atualizarInformacoes(dados);
    }

    @GetMapping
    public Page<ListPessoaFisica> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ListPessoaFisica::new);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PutPessoaFisica> findById(@PathVariable Long id) {
        log.info("Recebido o pedido de informações do cliente com id  {}", id);
        var pf = service.findById(id);
        if (pf != null) {
            return ResponseEntity.ok(new PutPessoaFisica(pf));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
