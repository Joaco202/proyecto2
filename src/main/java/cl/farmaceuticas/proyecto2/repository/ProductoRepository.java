package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findById(Integer id);
    boolean existsById(Integer id);
}
