package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.TransaccionesCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  
import java.util.Optional;

@Repository
public interface TransaccionesCajaRepository extends JpaRepository<TransaccionesCaja, Integer> {
    Optional<TransaccionesCaja> findById(Integer id);
    boolean existsById(Integer id);
    List<TransaccionesCaja> findByBodegaId(Integer bodegaId);
}
