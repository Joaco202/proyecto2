package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.GuiasDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GuiasDespachoRepository extends JpaRepository<GuiasDespacho, Integer> {
    Optional<GuiasDespacho> findById(Integer id);
    boolean existsById(Integer id);
}
