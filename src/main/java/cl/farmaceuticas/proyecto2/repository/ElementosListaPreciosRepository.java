package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.ElementosListaPrecios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ElementosListaPreciosRepository extends JpaRepository<ElementosListaPrecios, Integer> {
    Optional<ElementosListaPrecios> findById(Integer id);
    boolean existsById(Integer id);
}