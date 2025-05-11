package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.NotasCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NotasCreditoRepository extends JpaRepository<NotasCredito, Integer> {
    Optional<NotasCredito> findById(Integer id);
    boolean existsById(Integer id);
    Optional<NotasCredito> findByNumeroNotaCredito(String numeroNotaCredito);
}
