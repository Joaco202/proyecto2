package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.ListasPrecios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  
import java.util.Optional;

@Repository
public interface ListasPreciosRepository extends JpaRepository<ListasPrecios, Integer> {
    Optional<ListasPrecios> findById(Integer id);
    boolean existsById(Integer id);
    List<ListasPrecios> findByBodegaId(Integer bodegaId);
}
