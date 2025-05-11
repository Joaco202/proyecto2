package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.ReglasAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReglasAlertaRepository extends JpaRepository<ReglasAlerta, Integer> {
    Optional<ReglasAlerta> findById(Integer id);
    boolean existsById(Integer id);
    List<ReglasAlerta> findByBodegaId(Integer bodegaId);
}
