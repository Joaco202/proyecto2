package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.HistorialPacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface HistorialPacientesRepository extends JpaRepository<HistorialPacientes, Integer> {
    Optional<HistorialPacientes> findById(Integer id);
    boolean existsById(Integer id);
    List<HistorialPacientes> findByBeneficiarioId(Integer beneficiarioId);
}
