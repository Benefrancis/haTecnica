package desafio.domain.documento.repository;

import desafio.domain.documento.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("FROM Documento d where d.cliente.id=:id")
    public List<Documento> findByClienteId(Long id);


}