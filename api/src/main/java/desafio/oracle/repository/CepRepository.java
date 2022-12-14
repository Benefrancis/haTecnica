package desafio.oracle.repository;

import desafio.model.cliente.CEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<CEP, Long> {
}
