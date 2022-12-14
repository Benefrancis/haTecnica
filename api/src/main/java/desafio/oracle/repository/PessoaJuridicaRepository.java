package desafio.oracle.repository;

import desafio.model.cliente.PessoaJuridica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    Page<PessoaJuridica> findAll(Pageable paginacao);
}
