package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.HistorialPacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HistorialPacientesRepository extends JpaRepository<HistorialPacientes, Integer> {
    Optional<HistorialPacientes> findById(Integer id);
    boolean existsById(Integer id);
}
