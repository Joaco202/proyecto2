package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
    Optional<Ventas> findById(Integer id);
    boolean existsById(Integer id);
}
