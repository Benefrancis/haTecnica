package desafio.domain.cliente.controller;


import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.dto.ListCliente;
import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.cliente.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteService service;

    @Autowired
    ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PutCliente> save(@RequestBody @Valid PutCliente dados, UriComponentsBuilder builder) {
        var cliente = service.save(new Cliente(dados));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PutCliente(cliente));
    }

    @PutMapping
    @Transactional
    public void atualizarPessoaFisica(@RequestBody @Valid PutCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @GetMapping
    public Page<ListCliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ListCliente::new);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PutCliente> findById(@PathVariable Long id) {
        log.info("Recebido o pedido de informações do cliente com id  {}", id);
        var cliente = service.findById(id);
        if (cliente != null) {
            return ResponseEntity.ok(new PutCliente(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
