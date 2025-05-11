package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Dispensaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DispensacionesRepository extends JpaRepository<Dispensaciones, Integer> {
    Optional<Dispensaciones> findById(Integer id);
    boolean existsById(Integer id);
}
