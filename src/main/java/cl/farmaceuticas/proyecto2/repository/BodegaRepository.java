package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
    Optional<Bodega> findById(Integer id);
    boolean existsById(Integer id);
}
