package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Dispersiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DispersionesRepository extends JpaRepository<Dispersiones, Integer> {
    Optional<Dispersiones> findById(Integer id);
    boolean existsById(Integer id);
}
