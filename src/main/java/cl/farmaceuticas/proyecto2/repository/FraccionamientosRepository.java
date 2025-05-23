package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Fraccionamientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FraccionamientosRepository extends JpaRepository<Fraccionamientos, Integer> {
    Optional<Fraccionamientos> findById(Integer id);
    boolean existsById(Integer id);
}
