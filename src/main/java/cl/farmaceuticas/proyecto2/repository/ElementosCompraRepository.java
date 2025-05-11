package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.ElementosCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ElementosCompraRepository extends JpaRepository<ElementosCompra, Integer> {
    Optional<ElementosCompra> findById(Integer id);
    boolean existsById(Integer id);
}
