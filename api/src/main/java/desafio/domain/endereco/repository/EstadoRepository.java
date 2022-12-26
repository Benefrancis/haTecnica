package desafio.domain.endereco.repository;

import desafio.domain.endereco.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    boolean existsBySiglaIgnoreCase(String sigla);
}
