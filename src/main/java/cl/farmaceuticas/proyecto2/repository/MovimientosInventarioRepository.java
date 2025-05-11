package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.MovimientosInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientosInventarioRepository extends JpaRepository<MovimientosInventario, Integer> {
    Optional<MovimientosInventario> findById(Integer id);
    boolean existsById(Integer id);
    List<MovimientosInventario> findByBodegaId(Integer bodegaId);
}
