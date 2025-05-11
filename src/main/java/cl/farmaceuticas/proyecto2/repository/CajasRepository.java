package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Cajas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CajasRepository extends JpaRepository<Cajas, Integer> {
    Optional<Cajas> findById(Integer id);
    boolean existsById(Integer id);
}