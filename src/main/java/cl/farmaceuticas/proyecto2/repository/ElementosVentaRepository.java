package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.ElementosVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ElementosVentaRepository extends JpaRepository<ElementosVenta, Integer> {
    Optional<ElementosVenta> findById(Integer id);
    boolean existsById(Integer id);
}
