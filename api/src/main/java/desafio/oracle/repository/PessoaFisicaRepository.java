package desafio.oracle.repository;

import desafio.model.cliente.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Page<PessoaFisica> findAll(Pageable paginacao);
}
