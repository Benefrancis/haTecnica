package desafio.domain.servico.repository;

import desafio.domain.servico.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
    boolean existsByNomeIgnoreCase(String nome);
}
